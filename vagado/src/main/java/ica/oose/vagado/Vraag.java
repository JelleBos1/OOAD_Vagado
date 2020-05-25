package ica.oose.vagado;

import java.util.concurrent.atomic.AtomicInteger;

import static ica.oose.vagado.Vagado.PRINTER;

public abstract class Vraag {

    private int id;
    private Vragenlijst vragenlijst;
    private String vraag;

    public Vraag(int id, Vragenlijst vragenlijst, String vraag) {
        this.id = id;
        this.vragenlijst = vragenlijst;
        this.vraag = vraag;
    }

    private String getVraag() {
        return vraag;
    }

    protected int getId() {
        return id;
    }

    protected Vragenlijst getVragenlijst() {
        return vragenlijst;
    }

    protected void printVraag(AtomicInteger index) {
        PRINTER.printToScreen("Vraag " + index + ": " + getVraag());
    }

    protected abstract boolean controleerAntwoord(String antwoord);
}
