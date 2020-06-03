package ica.oose.vagado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ica.oose.vagado.Vagado.PRINTER;

public class Speler extends Account {

    private int munten;
    private ArrayList<Bezit> bezitten = new ArrayList<>();
    protected ArrayList<GegevenAntwoorden> spelerAntwoorden = new ArrayList<>();
    static final int START_SALDO = 100;

    public Speler(String gebruikersnaam, String wachtwoord, Taal taal) {
        super(gebruikersnaam, wachtwoord, taal);
        this.setMunten(START_SALDO);

        //Instantie aanmaken naar QuizDate om alle vragenlijsten op te halen en als bezit aan een Speler toe te voegen.
        //Niet opgenomen in DCD omdat het gaat om het aanmaken van data
        QuizData quizData = new QuizData();
        ArrayList<Vragenlijst> vragenlijsten = quizData.getVragenlijsten();
        vragenlijsten.forEach((vragenlijst) -> bezitten.add(new Bezit(0, java.time.LocalDate.now(), vragenlijst)));
    }

    public int getMunten() {
        return munten;
    }

    public void setMunten(int munten) {
        this.munten = munten;
    }

    public void voegMuntenToe(int munten){
        this.munten += munten;
    }

    //Methode wordt niet gebruikt, maar zou in een volgende iteratie bruikbaar zijn bij het
    // aanschaffen van nieuwe vragenlijsten
    public void verlaagMuntenSaldo(int aankoopPrijs){
        setMunten(getMunten() - aankoopPrijs);
    }

    //Methode nu niet echt nodig, maar met oog op de toekomst is deze methode bruikbaar om bijvoorbeeld alle
    // highscores te bekijken of te bekijken welke vragenlijsten een speler bezit.
    public ArrayList<Bezit> getBezitten() {
        return bezitten;
    }

    public Bezit getBezit(Vragenlijst vragenlijst){
        ArrayList<Bezit> bezitten = getBezitten();
        List<Bezit> bezit;
        bezit = bezitten.stream().filter(bezitVanVragenlijst -> bezitVanVragenlijst.getVragenlijst().getNaam().equals(vragenlijst.getNaam())).collect(Collectors.toList());

        return bezit.get(0);
    }

    public void setHighScore(int behaaldeScore, Vragenlijst vragenlijst){
        Bezit bezit = getBezit(vragenlijst);
        PRINTER.printToScreen("Oude highscore: " + bezit.getHighscore() + " punten");

        if (behaaldeScore > bezit.getHighscore()){
            bezit.setHighscore(behaaldeScore);
            PRINTER.printToScreen("Gefeliciteerd, je hebt een nieuwe highscore behaald voor de vragenlijst " + vragenlijst.getNaam());
            PRINTER.printToScreen("Nieuwe highscore: " + behaaldeScore + " punten");
        };
    }
}
