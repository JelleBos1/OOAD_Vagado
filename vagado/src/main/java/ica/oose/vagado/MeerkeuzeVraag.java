package ica.oose.vagado;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {

    private String goedeAntwoord;
    private ArrayList<String> fouteAntwoorden;

    public MeerkeuzeVraag(int id, Vragenlijst vragenlijst, String vraag, String goedeAntwoord, ArrayList<String> fouteAntwoorden) {
        super(id, vragenlijst, vraag, fouteAntwoorden);
    }

    public String getGoedeAntwoord() {
        return goedeAntwoord;
    }

    public ArrayList<String> getFouteAntwoorden() {
        return fouteAntwoorden;
    }
}
