package ica.oose.vagado;

import java.util.ArrayList;

public class Vragenlijst {

    private int themaId;
    private int vragenlijstId;
    public String naam;
    public int aankoopPrijs;
    ArrayList<Vraag> alleVragen;

    public Vragenlijst(int themaId, int vragenlijstId, String naam) {
        this.themaId = themaId;
        this.vragenlijstId = vragenlijstId;
        this.naam = naam;
    }

    public Vragenlijst(int themaId, int vragenlijstId, String naam, int aankoopPrijs) {
        this.themaId = themaId;
        this.vragenlijstId = vragenlijstId;
        this.naam = naam;
        this.aankoopPrijs = aankoopPrijs;
    }

    public ArrayList<Vraag> getRandomQuizVragen(Vragenlijst vragenlijst){
        ArrayList<Vraag> vragen = new ArrayList<Vraag>();
        return vragen;
    }

    public ArrayList<Vragenlijst> getVragenlijsten(Thema thema){
        ArrayList<Vragenlijst> vragenlijsten = new ArrayList<Vragenlijst>();
        return vragenlijsten;
    }
}
