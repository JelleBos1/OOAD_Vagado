package ica.oose.vagado;

/**
 * Vagado
 *
 */
public class Vagado
{
    protected final static IPrinter PRINTER = new PrinterConsole();
    protected final static IInput INPUT = new InputScanner();

    public static void main( String[] args )
    {

        Speler speler = new Speler("Speler 1", "wachtwoord", new Taal("Nederlands"));
        IPuntentelling puntentelling = new PuntentellingVagado();

        //De drie geimplementeerde vragenlijsten. Om een andere vragenlijst te spelen, verander simpelweg de vragenlijst in de constructor van Kennisquiz
        Vragenlijst vragenlijstFormule1 = new Vragenlijst("Sport - Formule 1");
        Vragenlijst vragenlijstHonkbal = new Vragenlijst("Sport - Honkbal");
        Vragenlijst vragenlijstMuziek = new Vragenlijst("Muziek - Algemeen");

        Kennisquiz kennisquiz = new Kennisquiz(speler, puntentelling, vragenlijstFormule1);
        kennisquiz.speelSpel();
    }
}
