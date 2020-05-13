package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Kennisquiz {

    protected final static Printer PRINTER = new PrinterConsole();
    protected final static Input INPUT = new InputScanner();

    protected static final int ALLES_GOED_MUNTEN_PRIJS = 2;
    protected static final int AANTAL_QUIZ_VRAGEN = 10;

    protected final static String antwoordGoedText = "Dat antwoord is goed!";
    protected final static String antwoordFoutText = "Dat antwoord is fout!";

    private double speelTijd;
    public int aantalGoedeAntwoorden;
    private String gekozenVragenlijst;
    private ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();
    public List<Vraag> quizVragen = new ArrayList<>();

    private IPuntentelling puntentelling;

    StopWatch timer = new StopWatch();

    SpelInitialisatie si = new SpelInitialisatie();

    public Kennisquiz(IPuntentelling puntentelling) {
        this.puntentelling = puntentelling;
    }

    public void speelSpel(){

        PRINTER.printToScreen("Welkom bij Vagado " + si.getSpeler().getGebruikersnaam());
        si.kiesThema();
        si.kiesVragenlijst();

        PRINTER.printHeaderToScreen("DE QUIZ START NU");

        gekozenVragenlijst = si.getGekozenVragenlijst();
        speelVragen(gekozenVragenlijst);

        PRINTER.printHeaderToScreen("SCORE");

        speelTijd = ((double)timer.getTime() / 1000);
        PRINTER.printToScreen("Je hebt er " + speelTijd + " seconden over gedaan.");
        PRINTER.printToScreen("De behaalde score is " + this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd) + " punten");
        verhoogMunten(aantalGoedeAntwoorden);
        setHighScore(this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd));
        slaAntwoordenOp();
    }

    public void speelVragen(String vragenlijst){

        si.vulVragenPerVragenlijst(vragenlijst);
        si.getRandomQuizVragen();

        timer.start();

        //Normale integer werkt niet binnen een Lambda expressie
        AtomicInteger index = new AtomicInteger(1);

        quizVragen = si.getRandomQuizVragen();

        quizVragen.forEach((vraag) -> {
            String antwoord;
            if (vraag instanceof OpenVraag){
                vraag.printVraag(index);

                antwoord = INPUT.getInput();
                if (vraag.controleerAntwoord(antwoord)){
                    PRINTER.printToScreen(antwoordGoedText);
                    PRINTER.printToScreen("\n");

                    aantalGoedeAntwoorden++;
                }
                else {
                    PRINTER.printToScreen(antwoordFoutText);
                    PRINTER.printToScreen("\n");
                }
                slaAntwoordOp(vraag.getId(), antwoord);
            }

            if (vraag instanceof MeerkeuzeVraag){
                vraag.printVraag(index);
                ((MeerkeuzeVraag) vraag).printMogelijkeAntwoorden();

                antwoord = INPUT.getInput();
                if (vraag.controleerAntwoord(antwoord)){
                    PRINTER.printToScreen(antwoordGoedText);
                    PRINTER.printToScreen("\n");
                    aantalGoedeAntwoorden++;
                }
                else {
                    PRINTER.printToScreen(antwoordFoutText);
                    PRINTER.printToScreen("\n");
                }

                slaAntwoordOp(vraag.getId(), antwoord);
            }
            index.getAndIncrement();
        });
        timer.stop();
    }

    public void setHighScore(int behaaldeScore){
        ArrayList<Bezit> bezitten = si.getSpeler().getBezitten();
        List<Bezit> bezit;
        bezit = bezitten.stream().filter(bezitVanVragenlijst -> bezitVanVragenlijst.getVragenlijst().equals(gekozenVragenlijst)).collect(Collectors.toList());

        PRINTER.printToScreen("Oude highscore: " + bezit.get(0).getHighscore() + " punten");

        if (behaaldeScore > bezit.get(0).getHighscore()){
            bezit.get(0).setHighscore(behaaldeScore);
            PRINTER.printToScreen("Gefeliciteerd, je hebt een nieuwe highscore behaald voor deze vragenlijst.");
            PRINTER.printToScreen("Nieuwe highscore: " + behaaldeScore + " punten");
        };
    }

    public void slaAntwoordenOp(){
        GegevenAntwoorden gegevenAntwoorden = new GegevenAntwoorden(aantalGoedeAntwoorden, speelTijd, antwoordenSpeler, gekozenVragenlijst);
        si.getSpeler().spelerAntwoorden.add(gegevenAntwoorden);
    }

    public void slaAntwoordOp(int vraagId, String antwoord){
        antwoordenSpeler.add(new Antwoord(vraagId, antwoord));
    }

    public void verhoogMunten (int aantalGoedeAntwoorden) {
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            si.getSpeler().voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS);
        }
    }
}
