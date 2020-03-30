package ica.oose.vagado;

public abstract class Account {

    private String gebruikersnaam;
    private String wachtwoord;
    private Taal taal;


    public Account(String gebruikersnaam, String wachtwoord, Taal taal) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.taal = taal;
    }


    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }
}
