package ica.oose.vagado;

import java.util.ArrayList;

public abstract class Vraag {

    private int id;
    private Vragenlijst vragenlijst;
    private String vraag;

    public Vraag(int id, Vragenlijst vragenlijst, String vraag) {
        this.id = id;
        this.vragenlijst = vragenlijst;
        this.vraag = vraag;
    }

    public String getVraag() {
        return vraag;
    }

    public int getId() {
        return id;
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }
}
