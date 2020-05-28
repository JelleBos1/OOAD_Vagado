package ica.oose.vagado;

//Implementatie van IPuntentelling om de Strategy inzichtbaar te maken. Deze puntentelling kan gebruikt worden
// in Vagado, maar er is geen 'geldige' berekening van de score toegevoegd
public class PuntentellingAndereQuiz implements IPuntentelling {

    @Override
    public int berekenScore(int aantalGoedeAntwoorden, double speelTijd) {
        return 0;
    }
}
