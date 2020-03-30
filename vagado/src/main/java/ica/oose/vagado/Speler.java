package ica.oose.vagado;

public class Speler extends Account {

    private int munten;

    public Speler(String gebruikersnaam, String wachtwoord, Taal taal) {
        super(gebruikersnaam, wachtwoord, taal);
        this.setMunten(100);
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
}
