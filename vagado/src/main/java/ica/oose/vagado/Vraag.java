package ica.oose.vagado;

public abstract class Vraag {

    private int id;
    private int vragenlijstId;
    private String vraag;

    public Vraag(int id, int vragenlijstId, String vraag) {
        this.id = id;
        this.vragenlijstId = vragenlijstId;
        this.vraag = vraag;
    }
}
