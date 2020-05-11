package ica.oose.vagado;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vraag {

    protected Printer printer = new PrinterConsole();


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

    public void printVraag(AtomicInteger index) {
        printer.printToScreen("Vraag " + index + ": " + getVraag());
    }

    protected abstract boolean controleerAntwoord(String antwoord);
}
