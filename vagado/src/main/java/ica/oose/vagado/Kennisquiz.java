package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static ica.oose.vagado.Vagado.INPUT;
import static ica.oose.vagado.Vagado.PRINTER;

public class Kennisquiz {

    private static final int ALLES_GOED_MUNTEN_PRIJS = 2;
    protected static final int AANTAL_QUIZ_VRAGEN = 10;

    private final String ANTWOORD_GOED_TEXT = "Dat antwoord is goed!";
    private final String ANTWOORD_FOUT_TEXT = "Dat antwoord is fout!";

    private double speelTijd;
    private int aantalGoedeAntwoorden;
    private ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();
    private GegevenAntwoorden gegevenAntwoorden = null;

    private IPuntentelling puntentelling;
    private Speler speler;
    private Vragenlijst vragenlijst;

    private StopWatch timer = new StopWatch();
    private IQuizData quizData = new QuizData();

    public Kennisquiz(Speler speler, IPuntentelling puntentelling, Vragenlijst vragenlijst) {
        this.speler = speler;
        this.puntentelling = puntentelling;
        this.vragenlijst = vragenlijst;
    }

    public void speelSpel(){

        PRINTER.printToScreen("Welkom bij Vagado " + speler.getGebruikersnaam());
        PRINTER.printHeaderToScreen("DE QUIZ START NU");
        PRINTER.printToScreen("De vragenlijst waarmee de quiz gespeeld wordt is " + vragenlijst.getNaam() + "\n");

        speelVragen(vragenlijst);

        PRINTER.printHeaderToScreen("SCORE");

        speelTijd = ((double)timer.getTime() / 1000);
        PRINTER.printToScreen("Je hebt er " + speelTijd + " seconden over gedaan.");
        PRINTER.printToScreen("De behaalde score is " + puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd) + " punten");
        verhoogMunten(aantalGoedeAntwoorden);
        speler.setHighScore(puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd), vragenlijst);
        slaAntwoordenOp();
    }

    public void speelVragen(Vragenlijst vragenlijst){

        timer.start();

        //Normale integer werkt niet binnen een Lambda expressie
        AtomicInteger index = new AtomicInteger(1);

        List<Vraag> gekozenVragen = quizData.filterVragen(vragenlijst);

        vragenlijst.getRandomQuizVragen(gekozenVragen).forEach((vraag) -> {
            String antwoord;

            vraag.printVraag(index);

            if (vraag instanceof MeerkeuzeVraag){
                ((MeerkeuzeVraag) vraag).printMogelijkeAntwoorden();
            }

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
            antwoordenSpeler.add(new Antwoord(vraag.getId(), antwoord));

            index.getAndIncrement();

        });
        timer.stop();
    }

    public void slaAntwoordenOp(){
        gegevenAntwoorden = new GegevenAntwoorden(aantalGoedeAntwoorden, speelTijd, antwoordenSpeler, vragenlijst);
        speler.spelerAntwoorden.add(gegevenAntwoorden);
    }

    public void verhoogMunten (int aantalGoedeAntwoorden) {
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            speler.voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS);
        }
    }
}
