package ica.oose.vagado;

import java.util.ArrayList;

public class OpenVraag extends Vraag {

    private ArrayList<String> goedeAntwoorden;

    public OpenVraag(int id, String vraag, ArrayList<String> goedeAntwoorden) {
        super(id, vraag);
    }
}
