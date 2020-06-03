package ica.oose.vagado;

public class Vagado
{
    protected final static IPrinter PRINTER = new PrinterConsole();
    protected final static IInput INPUT = new InputScanner();

    public static void main( String[] args )
    {

        Speler speler = new Speler("speler1@vagado.nl", "wachtwoord", new Taal("Nederlands"));
        IPuntentelling puntentelling = new PuntentellingVagado();

        //De drie geimplementeerde vragenlijsten. Om een andere vragenlijst te spelen, verander simpelweg de vragenlijst bij het aanroepen van speelSpel()
        Vragenlijst vragenlijstFormule1 = new Vragenlijst("Sport - Formule 1");
        Vragenlijst vragenlijstHonkbal = new Vragenlijst("Sport - Honkbal");
        Vragenlijst vragenlijstMuziek = new Vragenlijst("Muziek - Algemeen");

        Kennisquiz kennisquiz = new Kennisquiz();
        kennisquiz.speelSpel(speler, puntentelling, vragenlijstFormule1);
    }
}
