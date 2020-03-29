package ica.oose.vagado;

import java.util.ArrayList;

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
    }

    public void speelSpel(Vragenlijst lijst){

    }

    public void startTimer(){
//        ArrayList<String> antwoorden = new ArrayList<>();
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        Vraag vraag1 = new OpenVraag(1, "asdfa", antwoorden);
//        Vraag vraag2 = new MeerkeuzeVraag(1, "asdf", "asdfasdf", antwoorden);
//
//        ArrayList<Vraag> vragen = new ArrayList<>();
//        vragen.add(vraag1);
//        vragen.add(vraag2);
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
