package ica.oose.vagado;

import java.util.ArrayList;

public class Thema {

    public int id;

    public String getNaam() {
        return naam;
    }

    public String naam;

    public Thema(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public ArrayList<Thema> getAlleThemas() {
        ArrayList<Thema> themas = new ArrayList<Thema>();
        return themas;
    }
}
