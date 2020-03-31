package ica.oose.vagado;

public class Speler extends Account {

    private int munten;
//    private Setup setup = new Setup();


    public Speler(String gebruikersnaam, String wachtwoord, Taal taal) {
        super(gebruikersnaam, wachtwoord, taal);
        this.setMunten(100);
//        Bezit bezit1 = new Bezit(0, java.time.LocalDate.now(), gebruikersnaam, setup.vragenlijstSportFormule1);
//        Bezit bezit2 = new Bezit(0, java.time.LocalDate.now(), gebruikersnaam, setup.vragenlijstSportHonkbal);
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
