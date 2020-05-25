package ica.oose.vagado;

import java.util.ArrayList;

public class Speler extends Account {

    private int munten;
    private ArrayList<Bezit> bezitten = new ArrayList<>();
    protected ArrayList<GegevenAntwoorden> spelerAntwoorden = new ArrayList<>();

    public Speler(String gebruikersnaam, String wachtwoord, Taal taal) {
        super(gebruikersnaam, wachtwoord, taal);
        this.setMunten(100);

        //Instantie aanmaken naar SpelInitialisatie om alle vragenlijsten op te halen en als bezit aan een Speler toe te voegen.
        //Niet opgenomen in DCD omdat het gaat om het aanmaken van data
        SpelInitialisatie si = new SpelInitialisatie();
        ArrayList<Vragenlijst> vragenlijsten = si.getVragenlijsten();
        vragenlijsten.forEach((vragenlijst) -> bezitten.add(new Bezit(0, java.time.LocalDate.now(), gebruikersnaam, vragenlijst)));
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

    public void verlaagMuntenSaldo(int aankoopPrijs){
        setMunten(getMunten() - aankoopPrijs);
    }

    public ArrayList<Bezit> getBezitten() {
        return bezitten;
    }
}
