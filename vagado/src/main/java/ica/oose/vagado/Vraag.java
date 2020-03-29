package ica.oose.vagado;

public abstract class Vraag {

    private int id;
    private String vraag;

    public Vraag(int id, String vraag) {
        this.id = id;
        this.vraag = vraag;
    }
}
