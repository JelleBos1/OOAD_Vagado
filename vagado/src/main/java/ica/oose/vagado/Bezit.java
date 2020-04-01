package ica.oose.vagado;

import java.time.LocalDate;

public class Bezit {

    private int highscore;
    private LocalDate aankoopDatum;
    private String gebruikersnaam;
    private String vragenlijst;

    public Bezit(int highscore, LocalDate aankoopDatum, String gebruikersnaam, String vragenlijst) {
        this.highscore = highscore;
        this.aankoopDatum = aankoopDatum;
        this.gebruikersnaam = gebruikersnaam;
        this.vragenlijst = vragenlijst;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String getVragenlijst() {
        return vragenlijst;
    }
}
