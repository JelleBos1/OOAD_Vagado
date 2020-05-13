package ica.oose.vagado;

import static ica.oose.vagado.Kennisquiz.AANTAL_QUIZ_VRAGEN;

public class PuntentellingVagado implements IPuntentelling {

    private int maxTijdBonus = 100;
    private int allesGoedBonus = 50;

    @Override
    public int berekenScore(int aantalGoedeAntwoorden, double speelTijd) {
        int behaaldeScore = 0;

        behaaldeScore += (int)(maxTijdBonus-speelTijd); //bonuspunten speeltijd
        if (behaaldeScore < 0) behaaldeScore = 0;

        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            behaaldeScore += allesGoedBonus;       // bonus alle vragen goed
        }

        behaaldeScore += aantalGoedeAntwoorden * AANTAL_QUIZ_VRAGEN; // punten berekening

        return behaaldeScore;
    }
}
