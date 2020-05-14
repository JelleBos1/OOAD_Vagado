package ica.oose.vagado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ica.oose.vagado.Kennisquiz.AANTAL_QUIZ_VRAGEN;

public class Vragenlijst {

    private String thema;
    public String naam;
    public int aankoopPrijs;

    public Vragenlijst(String naam){
        this.naam = naam;
    }

    public Vragenlijst(String thema, String naam, int aankoopPrijs) {
        this.thema = thema;
        this.naam = naam;
        this.aankoopPrijs = aankoopPrijs;
    }

    public String getNaam() {
        return naam;
    }

    public String getThema() {
        return thema;
    }

    public ArrayList<Vraag> getRandomQuizVragen(List<Vraag> gekozenVragen){

        ArrayList<Vraag> vragen = new ArrayList<>();
        Collections.shuffle(gekozenVragen);

        for (int i = 0; i<AANTAL_QUIZ_VRAGEN; i++){
            vragen.add(gekozenVragen.get(i));
        }
        return vragen;
    }

}
