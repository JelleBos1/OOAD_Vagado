package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ica.oose.vagado.Puntentelling.allesGoedMuntenPrijs;

public class Kennisquiz {

    public double speelTijd;
    public int aantalGoedeAntwoorden;
    public int behaaldeScore;
    public Vraag huidigeVraag;
    public Speler speler;
    public ArrayList<Vraag> quizvragen;
    public ArrayList<Thema> themas;
    public Thema gekozenThema;
    public ArrayList<Vragenlijst> vragenlijsten;
    public Vragenlijst gekozenVragenlijst;
    public static int aantalVragen = 10;
    List<Vraag> gekozenVragen;

    Setup setup = new Setup();

    public Kennisquiz() {

        Scanner scanner = new Scanner(System.in);
        StopWatch timer = new StopWatch();

        VraagInitialisatie vi = new VraagInitialisatie();
        themas = vi.setThemas();
        speler = vi.setSpeler();
        vragenlijsten = vi.setVragenlijsten();
        quizvragen = vi.setVragen();

        System.out.println("Welkom bij Vagado " + speler.getGebruikersnaam());

        System.out.println("De besckikbare vragenlijsten binnen Vagado zijn: ");
        vragenlijsten.forEach((vragenlijst) -> System.out.println("- " + vragenlijst.getNaam()));

        System.out.println("Kies een vragenlijst");
        String gekozenVragenlijst = scanner.nextLine();

        System.out.println("Je hebt gekozen voor " + gekozenVragenlijst);

        vulVragenPerVragenlijst(gekozenVragenlijst);

        System.out.println("--------------------------------------------------------------------------");

        //Lijst met alle vragen die bij een vragenlijst horen
        List<Vraag> quizVragen = new ArrayList<>();

        Collections.shuffle(gekozenVragen);

        for (int i = 0; i<aantalVragen; i++){
//            System.out.println("Id: "+ quizVragen.get(i).getId() + ", " + quizVragen.get(i).getVraag());
            quizVragen.add(gekozenVragen.get(i));
        }

        //Spel start eerste vraag wordt gegeven
        ArrayList<Antwoord> gegevenAntwoorden = new ArrayList<>();
        AtomicInteger index = new AtomicInteger(1);

        timer.start();

        quizVragen.forEach((vraag) -> {

            System.out.println("Vraag " + index + ": " + vraag.getVraag());
            gegevenAntwoorden.add(new Antwoord(vraag.getId(), scanner.nextLine()));

            index.getAndIncrement();
            });

//            gekozen10vragen.forEach((vraag) -> {
//                if(vraag instanceof OpenVraag) {
//                    System.out.println("Vraag " + index + ": " + vraag.getVraag());
//                    gegevenAntwoorden.add(new Antwoord(vraag.getId(), scanner.nextLine()));
//
////                    for(String foutAntwoord : ((OpenVraag) vraag).getGoedeAntwoorden()) {
////                        System.out.println(foutAntwoord);
////                    }
////                    System.out.println(((OpenVraag) vraag).getGoedeAntwoorden().get(0));
//                    index.getAndIncrement();
//                }
//                if (vraag instanceof MeerkeuzeVraag) {
//                    System.out.println("Vraag " + index + ": " + vraag.getVraag());
//                    gegevenAntwoorden.add(new Antwoord(vraag.getId(), scanner.nextLine()));
//                    index.getAndIncrement();
////                    System.out.println(((MeerkeuzeVraag) vraag).getGoedeAntwoord());
////                    for(String foutAntwoord : ((MeerkeuzeVraag) vraag).getFouteAntwoorden()) {
////                        System.out.println(foutAntwoord);
////                    }
////                    System.out.println(((MeerkeuzeVraag) vraag).getGoedeAntwoord());
//                }
//            });

            timer.stop();

        for (Antwoord antwoord : gegevenAntwoorden) {
            System.out.println(antwoord.getAntwoord());
        }

        speelTijd = ((double)timer.getTime() / 1000);

        System.out.println("Je hebt er " + speelTijd + " seconden over gedaan.");

        System.out.println("De behaalde score is " + berekenScore(4, speelTijd) + " punten");

        // setHighscore
//        setup.bezit1.getHighscore();



    }


    public void speelSpel(Vragenlijst lijst){

    }

    public void controleerAntwoord(String goedeAntwoord, String input) {

    }

    public void controleerAntwoord(ArrayList<String> goedeAntwoorden, String input) {

    }

    public void getRandomQuizVragen(){

    }

    public void setHighScore(int behaaldeScore){

    }

    public void setThema(Thema thema){

    }

    public void setVragenlijst(Vragenlijst vragenlijst){

    }

    public void slaAntwoordOp(String input, Vraag vraag){

    }

    public int berekenScore(int aantalGoedeAntwoorden, double speeltijd){
        int behaaldeScore = 0;
        if (aantalGoedeAntwoorden == aantalVragen){
            setup.speler1.voegMuntenToe(allesGoedMuntenPrijs); // hoog munten op
            behaaldeScore += 50;       // bonus alle vragen goed
        }
        behaaldeScore += aantalGoedeAntwoorden * 10; // punten berekening
        behaaldeScore += (int)(100-speeltijd); //bonuspunten speeltijd

        return behaaldeScore;
    }

    public void vulVragenPerVragenlijst(String vragenlijst){
        gekozenVragen = quizvragen.stream().filter(vraag -> vraag.getVragenlijst().getNaam().equals(vragenlijst)).collect(Collectors.toList());
    }
}
