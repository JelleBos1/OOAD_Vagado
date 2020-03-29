package ica.oose.vagado;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {

    private String goedeAntwoord;
    private ArrayList<String> fouteAntwoorden;

    public MeerkeuzeVraag(int id, String vraag, String goedeAntwoord, ArrayList<String> fouteAntwoorden) {
        super(id, vraag);
    }
}
