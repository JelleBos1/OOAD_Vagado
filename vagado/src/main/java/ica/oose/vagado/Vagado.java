package ica.oose.vagado;

/**
 * Vagado
 *
 */
public class Vagado
{
    public static void main( String[] args )
    {
        Speler speler = new Speler("Speler 1", "wachtwoord", new Taal("Nederlands"));
        IPuntentelling puntentelling = new PuntentellingVagado();
        Vragenlijst vragenlijst = new Vragenlijst("Sport - Formule 1");

        Kennisquiz kennisquiz = new Kennisquiz(speler, puntentelling, vragenlijst);
        kennisquiz.speelSpel();
    }
}
