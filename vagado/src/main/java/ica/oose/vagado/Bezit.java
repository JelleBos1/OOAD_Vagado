package ica.oose.vagado;

import java.time.LocalDate;

public class Bezit {

    private int highscore;
    private LocalDate aankoopDatum;
    private Vragenlijst vragenlijst;

    public Bezit(int highscore, LocalDate aankoopDatum, Vragenlijst vragenlijst) {
        this.highscore = highscore;
        this.aankoopDatum = aankoopDatum;
        this.vragenlijst = vragenlijst;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }
}
