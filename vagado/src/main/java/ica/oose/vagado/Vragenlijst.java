package ica.oose.vagado;

public class Vragenlijst {

    private String thema;
    public String naam;
    public int aankoopPrijs;

    public Vragenlijst(String thema, String naam, int aankoopPrijs) {
        this.thema = thema;
        this.naam = naam;
        this.aankoopPrijs = aankoopPrijs;
    }

    public String getNaam() {
        return naam;
    }

    public String getThema() {
        return thema;
    }

}
