package ica.oose.vagado;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {

    private String goedAntwoord;
    private ArrayList<String> fouteAntwoorden;

    public MeerkeuzeVraag(int id, Vragenlijst vragenlijst, String vraag, String goedAntwoord, ArrayList<String> fouteAntwoorden) {
        super(id, vragenlijst, vraag);
        this.goedAntwoord = goedAntwoord;
        this.fouteAntwoorden = fouteAntwoorden;
    }

    public String getGoedAntwoord() {
        return goedAntwoord;
    }

    public ArrayList<String> getFouteAntwoorden() {
        return fouteAntwoorden;
    }
}
