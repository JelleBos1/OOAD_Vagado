package ica.oose.vagado;

import java.util.ArrayList;

public class GegevenAntwoorden {

    private String gebruikersnaam;
    private int aantalGoedeAntwoorden;
    private double speeltijd;
    private ArrayList<Antwoord> antwoordenSpeler;

    public GegevenAntwoorden(String gebruikersnaam, int aantalGoedeAntwoorden, double speeltijd, ArrayList<Antwoord> antwoordenSpeler) {
        this.gebruikersnaam = gebruikersnaam;
        this.aantalGoedeAntwoorden = aantalGoedeAntwoorden;
        this.speeltijd = speeltijd;
        this.antwoordenSpeler = antwoordenSpeler;
    }
}
