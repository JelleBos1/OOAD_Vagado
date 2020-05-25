package ica.oose.vagado;

import java.util.ArrayList;
import java.util.Collections;

import static ica.oose.vagado.Vagado.PRINTER;

public class MeerkeuzeVraag extends Vraag {

    private String goedAntwoord;
    private ArrayList<String> fouteAntwoorden;

    public MeerkeuzeVraag(int id, Vragenlijst vragenlijst, String vraag, String goedAntwoord, ArrayList<String> fouteAntwoorden) {
        super(id, vragenlijst, vraag);
        this.goedAntwoord = goedAntwoord;
        this.fouteAntwoorden = fouteAntwoorden;
    }

    public void printMogelijkeAntwoorden(){

        ArrayList<String> alleAntwoorden = new ArrayList<>();
        alleAntwoorden.add(goedAntwoord);

        for (String antwoord : fouteAntwoorden){
            alleAntwoorden.add(antwoord);
        }

        Collections.shuffle(alleAntwoorden);
        alleAntwoorden.forEach((antwoord) -> PRINTER.printToScreen("- " + antwoord));
    }

    @Override
    protected boolean controleerAntwoord(String antwoord) {
        if (antwoord.equals(goedAntwoord)){
            return true;
        }
        else {
            return false;
        }
    }
}
