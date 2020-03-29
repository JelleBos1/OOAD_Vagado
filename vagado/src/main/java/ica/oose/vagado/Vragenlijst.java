package ica.oose.vagado;

import java.util.ArrayList;

public class Vragenlijst {

    public String naam;
    public int aankoopPrijs;
    ArrayList<Vraag> alleVragen;

    public ArrayList<Vraag> getRandomQuizVragen(Vragenlijst vragenlijst){
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        return vragen;
    }

    public ArrayList<Vragenlijst> getVragenlijsten(Thema thema){
        ArrayList<Vragenlijst> vragenlijsten = new ArrayList<Vragenlijst>();
        return vragenlijsten;
    }
}
