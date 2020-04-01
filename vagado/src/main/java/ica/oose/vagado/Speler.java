package ica.oose.vagado;

import java.util.ArrayList;

public class Speler extends Account {

    private int munten;
//    private Setup setup = new Setup();
    ArrayList<Bezit> bezitten = new ArrayList<>();

    public Speler(String gebruikersnaam, String wachtwoord, Taal taal) {
        super(gebruikersnaam, wachtwoord, taal);
        this.setMunten(100);
        bezitten.add(new Bezit(0, java.time.LocalDate.now(), gebruikersnaam, "Formule 1"));
        bezitten.add(new Bezit(1000, java.time.LocalDate.now(), gebruikersnaam, "Honkbal"));
        bezitten.add(new Bezit(0, java.time.LocalDate.now(), gebruikersnaam, "Algemeen"));
    }

    public int getMunten() {
        return munten;
    }

    public void setMunten(int munten) {
        this.munten = munten;
    }

    public void voegMuntenToe(int munten){
        this.munten += munten;
    }

    public void koppelVragenlijstAanSpeler(Vragenlijst vragenlijst){

    }

    public void verlaagMuntenSaldo(int aankoopPrijs){
        setMunten(getMunten() - aankoopPrijs);
    }

    public ArrayList<Bezit> getBezitten() {
        return bezitten;
    }

    public void setBezitten(ArrayList<Bezit> bezitten) {
        this.bezitten = bezitten;
    }
}
