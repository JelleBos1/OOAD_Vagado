package ica.oose.vagado;

import static ica.oose.vagado.SpelInitialisatie.AANTAL_QUIZ_VRAGEN;

public class PuntentellingVagado extends Puntentelling {

    private int maxTijdBonus = 100;
    private int allesGoedBonus = 50;

    public int berekenScore(int aantalGoedeAntwoorden, double speelTijd) {
        int behaaldeScore = 0;
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            behaaldeScore += allesGoedBonus;       // bonus alle vragen goed
        }
        behaaldeScore += aantalGoedeAntwoorden * AANTAL_QUIZ_VRAGEN; // punten berekening
        behaaldeScore += (int)(maxTijdBonus-speelTijd); //bonuspunten speeltijd

        return behaaldeScore;
    }
}
