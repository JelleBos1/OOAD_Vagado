package ica.oose.vagado;

public class PuntentellingVagado extends Puntentelling {

    private int maxTijdBonus = 100;
    private int allesGoedBonus = 50;

    @Override
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
