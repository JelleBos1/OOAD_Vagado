package ica.oose.vagado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Kennisquiz {

    public int speelTijd;
    public int aantalGoedeAntwoorden;
    public int behaaldeScore;
    public Vraag huidigeVraag;
    public ArrayList<Vraag> quizvragen;
    public ArrayList<Thema> themas;
    public Thema gekozenThema;
    public ArrayList<Vragenlijst> vragenlijsten;
    public Vragenlijst gekozenVragenlijst;


    public Kennisquiz() {

        Scanner scanner = new Scanner(System.in);

        Setup setup = new Setup();

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
                quizVragen.add(vraag);
//                System.out.println(vraag.getVraag());
            });

        quizVragen.forEach((vraag) -> System.out.println("Id: " + vraag.getId() + ", vraag: " + vraag.getVraag()));
        System.out.println("----------------------");

        //Vul de lege arrayList gekozenVragen met de inhoud van quizVragen
        gekozenVragen = quizVragen;

        //Shuffle de lijst gekozenVragen
        Collections.shuffle(gekozenVragen);

        //Voeg de eerste 10 geshuffelde vragen toe aan nieuwe lijst gekozen10vragen
        for (int i = 0; i<10; i++){
            System.out.println("Id: "+ quizVragen.get(i).getId() + ", " + quizVragen.get(i).getVraag());
            gekozen10vragen.add(quizVragen.get(i));
        }
    }

    public void speelSpel(Vragenlijst lijst){

    }

    public void startTimer(){

    }

    public void stopTimer() {

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
}
