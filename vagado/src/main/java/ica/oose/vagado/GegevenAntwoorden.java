package ica.oose.vagado;

import java.util.ArrayList;

public class GegevenAntwoorden {

    private int aantalGoedeAntwoorden;
    private double speeltijd;
    private ArrayList<Antwoord> antwoordenSpeler;
    private String vragenlijst;

    public GegevenAntwoorden(int aantalGoedeAntwoorden, double speeltijd, ArrayList<Antwoord> antwoordenSpeler, String vragenlijst) {
        this.aantalGoedeAntwoorden = aantalGoedeAntwoorden;
        this.speeltijd = speeltijd;
        this.antwoordenSpeler = antwoordenSpeler;
        this.vragenlijst = vragenlijst;
    }
}
