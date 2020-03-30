package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static ica.oose.vagado.Puntentelling.allesGoedMuntenPrijs;

public class Kennisquiz {

    public double speelTijd;
    public int aantalGoedeAntwoorden;
    public int behaaldeScore;
    public Vraag huidigeVraag;
    public ArrayList<Vraag> quizvragen;
    public ArrayList<Thema> themas;
    public Thema gekozenThema;
    public ArrayList<Vragenlijst> vragenlijsten;
    public Vragenlijst gekozenVragenlijst;
    public static int aantalVragen = 10;

    Setup setup = new Setup();

    public Kennisquiz() {

        Scanner scanner = new Scanner(System.in);
        StopWatch timer = new StopWatch();


        System.out.println("Welkom bij Vagado " + setup.speler1.getGebruikersnaam());
        System.out.println("Kies een van de volgende thema's: ");
        setup.themas.forEach((thema) -> System.out.println("- " + thema.getNaam()));
        System.out.println("Welk thema wil je spelen?");
        String gekozenThema = scanner.nextLine();
        System.out.println("Je hebt gekozen voor " + gekozenThema);
        System.out.println("De volgende vragenlijsten zijn beschikbaar voor het gekozen thema " + gekozenThema);

        if (gekozenThema.equals("Sport")){
            setup.vragenlijstenSport.forEach((vragenlijst) -> System.out.println("- " + vragenlijst.getNaam()));
        }
        if (gekozenThema.equals("Muziek")){
            setup.vragenlijstenMuziek.forEach((vragenlijst) -> System.out.println("- " + vragenlijst.getNaam()));
        }
        String gekozenVragenlijst = scanner.nextLine();
        System.out.println("Je hebt gekozen voor " + gekozenVragenlijst);

        //Lijst met alle vragen die bij een vragenlijst horen
        ArrayList<Vraag> quizVragen = new ArrayList<>();

        //Lijst met geshuffelde vragen van een vragenlijst
        ArrayList<Vraag> gekozenVragen = new ArrayList<>();

        //Lijst met 10 geshuffelde vragen van een vragenlijst
        ArrayList<Vraag> gekozen10vragen = new ArrayList<>();

        //Vul quizVragen met alle vragen uit vragenlijst
        if (gekozenVragenlijst.equals("Honkbal"))
            setup.vragenSportHonkbal.forEach((vraag) -> {
                if (vraag instanceof OpenVraag){
                    quizVragen.add(vraag);

//                    System.out.println("vraag: " + vraag.getGoedeAntwoorden());
                }
                if (vraag instanceof MeerkeuzeVraag){
                    quizVragen.add(vraag);
//                    System.out.println("MPC antwoord: " + vraag.getGoedAntwoord());
//                    System.out.println(vraag.getFouteAntwoorden());
                }

            });

        quizVragen.forEach((vraag) -> System.out.println("Id: " + vraag.getId() + ", vraag: " + vraag.getVraag()));
        System.out.println("----------------------");

        //Vul de lege arrayList gekozenVragen met de inhoud van quizVragen
        gekozenVragen = quizVragen;

        //Shuffle de lijst gekozenVragen
        Collections.shuffle(gekozenVragen);

        //Voeg de eerste 10 geshuffelde vragen toe aan nieuwe lijst gekozen10vragen
        for (int i = 0; i<aantalVragen; i++){
            System.out.println("Id: "+ quizVragen.get(i).getId() + ", " + quizVragen.get(i).getVraag());
            gekozen10vragen.add(quizVragen.get(i));
        }

        //Spel start eerste vraag wordt gegeven
        ArrayList<Antwoord> gegevenAntwoorden = new ArrayList<>();
        AtomicInteger index = new AtomicInteger(1);

        timer.start();

            gekozen10vragen.forEach((vraag) -> {
                if(vraag instanceof OpenVraag) {
                    System.out.println("Vraag " + index + ": " + vraag.getVraag());
                    gegevenAntwoorden.add(new Antwoord(vraag.getId(), scanner.nextLine()));

//                    for(String foutAntwoord : ((OpenVraag) vraag).getGoedeAntwoorden()) {
//                        System.out.println(foutAntwoord);
//                    }
//                    System.out.println(((OpenVraag) vraag).getGoedeAntwoorden().get(0));
                    index.getAndIncrement();
                }
                if (vraag instanceof MeerkeuzeVraag) {
                    System.out.println("Vraag " + index + ": " + vraag.getVraag());
                    gegevenAntwoorden.add(new Antwoord(vraag.getId(), scanner.nextLine()));
                    index.getAndIncrement();
//                    System.out.println(((MeerkeuzeVraag) vraag).getGoedeAntwoord());
//                    for(String foutAntwoord : ((MeerkeuzeVraag) vraag).getFouteAntwoorden()) {
//                        System.out.println(foutAntwoord);
//                    }
//                    System.out.println(((MeerkeuzeVraag) vraag).getGoedeAntwoord());
                }
            });

            timer.stop();

        for (Antwoord antwoord : gegevenAntwoorden) {
            System.out.println(antwoord.getAntwoord());
        }

        speelTijd = ((double)timer.getTime() / 1000);

        System.out.println("Je hebt er " + speelTijd + " seconden over gedaan.");

        System.out.println("De behaalde score is " + berekenScore(4, speelTijd) + " punten");

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
        if (aantalGoedeAntwoorden == aantalVragen){
            //Hoog munten op
            setup.speler1.voegMuntenToe(allesGoedMuntenPrijs);
        }
        if (aantalGoedeAntwoorden * speeltijd > 100){
            behaaldeScore = 100;
        }

        behaaldeScore = 100;
        return behaaldeScore;

    }
}
