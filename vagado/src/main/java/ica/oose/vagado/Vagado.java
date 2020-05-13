package ica.oose.vagado;

/**
 * Vagado
 *
 */
public class Vagado
{
    public static void main( String[] args )
    {
        Speler speler1 = new Speler("Speler 1", "wachtwoord", new Taal("Nederlands"));

        Kennisquiz kennisquiz = new Kennisquiz(speler1, new PuntentellingVagado());
        kennisquiz.speelSpel();
    }
}
