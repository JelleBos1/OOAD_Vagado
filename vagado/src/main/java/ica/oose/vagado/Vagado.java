package ica.oose.vagado;

/**
 * Vagado
 *
 */
public class Vagado
{
    public static void main( String[] args )
    {
        Kennisquiz kennisquiz = new Kennisquiz(new PuntentellingVagado());
        kennisquiz.speelSpel();
    }
}
