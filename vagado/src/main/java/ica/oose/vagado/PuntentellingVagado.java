package ica.oose.vagado;

public class PuntentellingVagado extends Puntentelling {

    public int tijdBonus;
    public int allesGoedMuntenPrijs;
    public int aantalQuizVragen;

    @Override
    public int berekenScore(int aantalGoedeAntwoorden, int speelTijd) {
        return 0;
    }
}
