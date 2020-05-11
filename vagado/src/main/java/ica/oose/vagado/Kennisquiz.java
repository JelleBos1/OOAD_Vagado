package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ica.oose.vagado.SpelInitialisatie.AANTAL_QUIZ_VRAGEN;
import static ica.oose.vagado.SpelInitialisatie.ALLES_GOED_MUNTEN_PRIJS;

public class Kennisquiz {

    private double speelTijd;
    private int aantalGoedeAntwoorden;
    private ArrayList<Vraag> alleQuizvragen;
    private String gekozenVragenlijst;
    private ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();
    public List<Vraag> quizVragen = new ArrayList<>();

    private IPuntentelling puntentelling;
    private Printer printer = new PrinterConsole();

    private final String antwoordGoedText = "Dat antwoord is goed!";
    private final String antwoordFoutText = "Dat antwoord is fout!";

    Scanner scanner = new Scanner(System.in);
    StopWatch timer = new StopWatch();
    SpelInitialisatie si = new SpelInitialisatie();


    public Kennisquiz(IPuntentelling puntentelling) {

        alleQuizvragen = si.getVragen();
        this.puntentelling = puntentelling;
    }

    public void speelSpel(){

        printer.printToScreen("Welkom bij Vagado " + si.getSpeler().getGebruikersnaam());
        si.kiesThema();
        si.kiesVragenlijst();

        printer.printHeaderToScreen("DE QUIZ START NU");

        gekozenVragenlijst = si.getGekozenVragenlijst();
        speelVragen(gekozenVragenlijst);

        printer.printHeaderToScreen("SCORE");

        speelTijd = ((double)timer.getTime() / 1000);
        printer.printToScreen("Je hebt er " + speelTijd + " seconden over gedaan.");
        printer.printToScreen("De behaalde score is " + this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd) + " punten");
        verhoogMunten(aantalGoedeAntwoorden);
        setHighScore(this.puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd));
        slaAntwoordenOp();
    }

    public void speelVragen(String vragenlijst){

        si.vulVragenPerVragenlijst(vragenlijst);
        si.getRandomQuizVragen();

        timer.start();

        AtomicInteger index = new AtomicInteger(1);

        quizVragen = si.getRandomQuizVragen();

        quizVragen.forEach((vraag) -> {
            if (vraag instanceof OpenVraag){
                printer.printToScreen("Vraag " + index + ": " + vraag.getVraag());

                ArrayList<String> antwoorden = ((OpenVraag) vraag).getGoedeAntwoorden();

                String antwoord = scanner.nextLine();
                if (antwoorden.contains(antwoord)){
                    printer.printToScreen(antwoordGoedText);
                    printer.printToScreen("\n");

                    aantalGoedeAntwoorden++;
                }
                else {
                    printer.printToScreen(antwoordFoutText);
                    printer.printToScreen("\n");
                }

                slaAntwoordOp(vraag.getId(), antwoord);
            }

            if (vraag instanceof MeerkeuzeVraag){
                ArrayList<String> mogelijkeAntwoorden = new ArrayList<>();
                printer.printToScreen("Vraag " + index + ": " + vraag.getVraag());
                ArrayList<String> fouteAntwoorden = ((MeerkeuzeVraag) vraag).getFouteAntwoorden();

                fouteAntwoorden.forEach((antwoord) -> mogelijkeAntwoorden.add(antwoord));

                String goedAntwoord = ((MeerkeuzeVraag) vraag).getGoedAntwoord();
                mogelijkeAntwoorden.add(goedAntwoord);

                Collections.shuffle(mogelijkeAntwoorden);

                mogelijkeAntwoorden.forEach((antwoord) -> printer.printToScreen("- " + antwoord));

                String antwoord = scanner.nextLine();
                if (antwoord.equals(goedAntwoord)){
                    printer.printToScreen(antwoordGoedText);
                    printer.printToScreen("\n");
                    aantalGoedeAntwoorden++;
                }
                else {
                    printer.printToScreen(antwoordFoutText);
                    printer.printToScreen("\n");
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

        printer.printToScreen("Oude highscore: " + bezit.get(0).getHighscore() + " punten");

        if (behaaldeScore > bezit.get(0).getHighscore()){
            bezit.get(0).setHighscore(behaaldeScore);
            printer.printToScreen("Gefeliciteerd, je hebt een nieuwe highscore behaald voor deze vragenlijst.");
            printer.printToScreen("Nieuwe highscore: " + behaaldeScore + " punten");
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
            si.getSpeler().voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS); // hoog munten op
        }
    }

}
