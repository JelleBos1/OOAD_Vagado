package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Kennisquiz {

    protected final static IPrinter PRINTER = new PrinterConsole();
    protected final static IInput INPUT = new InputScanner();

    private static final int ALLES_GOED_MUNTEN_PRIJS = 2;
    protected static final int AANTAL_QUIZ_VRAGEN = 10;

    private final String ANTWOORD_GOED_TEXT = "Dat antwoord is goed!";
    private final String ANTWOORD_FOUT_TEXT = "Dat antwoord is fout!";

    private double speelTijd;
    public int aantalGoedeAntwoorden;
    private ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();
    private GegevenAntwoorden gegevenAntwoorden = null;
    List<Vraag> gekozenVragen = new ArrayList<>();

    private IPuntentelling puntentelling;
    private Speler speler;
    private Vragenlijst vragenlijst;

    StopWatch timer = new StopWatch();

    private SpelInitialisatie si = new SpelInitialisatie();

    public Kennisquiz(Speler speler, IPuntentelling puntentelling, Vragenlijst vragenlijst) {
        this.speler = speler;
        this.puntentelling = puntentelling;
        this.vragenlijst = vragenlijst;

    }

    public void speelSpel(){

        PRINTER.printToScreen("Welkom bij Vagado " + this.speler.getGebruikersnaam());
        PRINTER.printHeaderToScreen("DE QUIZ START NU");
        PRINTER.printToScreen("De vragenlijst waarmee de quiz gespeeld wordt is " + vragenlijst.getNaam() + "\n");

        speelVragen(vragenlijst);

        PRINTER.printHeaderToScreen("SCORE");

        speelTijd = ((double)timer.getTime() / 1000);
        PRINTER.printToScreen("Je hebt er " + speelTijd + " seconden over gedaan.");
        PRINTER.printToScreen("De behaalde score is " + this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd) + " punten");
        verhoogMunten(aantalGoedeAntwoorden);
        setHighScore(this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd));
        slaAntwoordenOp();
    }

    public void speelVragen(Vragenlijst vragenlijst){

        si.vulVragenPerVragenlijst(vragenlijst);

        gekozenVragen = si.getGekozenVragen();

        timer.start();

        //Normale integer werkt niet binnen een Lambda expressie
        AtomicInteger index = new AtomicInteger(1);

//        quizVragen = vragenlijst.getRandomQuizVragen(gekozenVragen);

        vragenlijst.getRandomQuizVragen(gekozenVragen).forEach((vraag) -> {
            String antwoord;
            if (vraag instanceof OpenVraag){
                vraag.printVraag(index);

                antwoord = INPUT.getInput();
                if (vraag.controleerAntwoord(antwoord)){
                    PRINTER.printToScreen(ANTWOORD_GOED_TEXT);
                    PRINTER.printToScreen("\n");

                    aantalGoedeAntwoorden++;
                }
                else {
                    PRINTER.printToScreen(ANTWOORD_FOUT_TEXT);
                    PRINTER.printToScreen("\n");
                }
                slaAntwoordOp(vraag.getId(), antwoord);
            }

            if (vraag instanceof MeerkeuzeVraag){
                vraag.printVraag(index);
                ((MeerkeuzeVraag) vraag).printMogelijkeAntwoorden();

                antwoord = INPUT.getInput();
                if (vraag.controleerAntwoord(antwoord)){
                    PRINTER.printToScreen(ANTWOORD_GOED_TEXT);
                    PRINTER.printToScreen("\n");
                    aantalGoedeAntwoorden++;
                }
                else {
                    PRINTER.printToScreen(ANTWOORD_FOUT_TEXT);
                    PRINTER.printToScreen("\n");
                }

                slaAntwoordOp(vraag.getId(), antwoord);
            }
            index.getAndIncrement();
        });
        timer.stop();
    }

    public void setHighScore(int behaaldeScore){
        ArrayList<Bezit> bezitten = this.speler.getBezitten();
        List<Bezit> bezit;
        bezit = bezitten.stream().filter(bezitVanVragenlijst -> bezitVanVragenlijst.getVragenlijst().getNaam().equals(this.vragenlijst.getNaam())).collect(Collectors.toList());

        PRINTER.printToScreen("Oude highscore: " + bezit.get(0).getHighscore() + " punten");

        if (behaaldeScore > bezit.get(0).getHighscore()){
            bezit.get(0).setHighscore(behaaldeScore);
            PRINTER.printToScreen("Gefeliciteerd, je hebt een nieuwe highscore behaald voor deze vragenlijst.");
            PRINTER.printToScreen("Nieuwe highscore: " + behaaldeScore + " punten");
        };
    }

    public void slaAntwoordenOp(){
        gegevenAntwoorden = new GegevenAntwoorden(aantalGoedeAntwoorden, speelTijd, antwoordenSpeler, vragenlijst);
        this.speler.spelerAntwoorden.add(gegevenAntwoorden);
    }

    public void slaAntwoordOp(int vraagId, String antwoord){
        antwoordenSpeler.add(new Antwoord(vraagId, antwoord));
    }

    public void verhoogMunten (int aantalGoedeAntwoorden) {
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            this.speler.voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS);
        }
    }
}
