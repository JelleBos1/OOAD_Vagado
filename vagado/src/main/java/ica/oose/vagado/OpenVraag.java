package ica.oose.vagado;

import java.util.ArrayList;

public class OpenVraag extends Vraag {

    private ArrayList<String> goedeAntwoorden;

    public OpenVraag(int id, Vragenlijst vragenlijst, String vraag, ArrayList<String> goedeAntwoorden) {
        super(id, vragenlijst, vraag);
        this.goedeAntwoorden = goedeAntwoorden;
    }

    public ArrayList<String> getGoedeAntwoorden() {
        return goedeAntwoorden;
    }
}
