package ica.oose.vagado;

import java.util.ArrayList;

public class Vragenlijst {

    private String thema;
    public String naam;
    public int aankoopPrijs;
    ArrayList<Vraag> alleVragen;


    public Vragenlijst(String thema, String naam) {
        this.thema = thema;
        this.naam = naam;
    }

    public ArrayList<Vraag> getRandomQuizVragen(Vragenlijst vragenlijst){
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        return vragen;
    }

    public ArrayList<Vragenlijst> getVragenlijsten(Thema thema){
        ArrayList<Vragenlijst> vragenlijsten = new ArrayList<Vragenlijst>();
        return vragenlijsten;
    }

    public String getNaam() {
        return naam;
    }

    public String getThema() {
        return thema;
    }
}
