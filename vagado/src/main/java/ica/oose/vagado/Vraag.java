package ica.oose.vagado;

import java.util.ArrayList;

public abstract class Vraag {


    private int id;
    private Vragenlijst vragenlijst;
    private String vraag;
    private ArrayList<String> goedeAntwoorden;
    private String goedAntwoord;
    private ArrayList<String> fouteAntwoorden;

    public Vraag(int id, Vragenlijst vragenlijst, String vraag, ArrayList<String> goedeAntwoorden) {
        this.id = id;
        this.vragenlijst = vragenlijst;
        this.vraag = vraag;
        this.goedeAntwoorden = goedeAntwoorden;
    }

    public String getVraag() {
        return vraag;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getGoedeAntwoorden() {
        return goedeAntwoorden;
    }

    public String getGoedAntwoord() {
        return goedAntwoord;
    }

    public ArrayList<String> getFouteAntwoorden() {
        return fouteAntwoorden;
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }
}
