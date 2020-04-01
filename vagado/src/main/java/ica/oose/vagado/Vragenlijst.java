package ica.oose.vagado;

import java.util.ArrayList;

public class Vragenlijst {

    private String thema;
    public String naam;
    public int aankoopPrijs;


    public Vragenlijst(String thema, String naam) {
        this.thema = thema;
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getThema() {
        return thema;
    }
}
