package ica.oose.vagado;

import java.util.ArrayList;

public class Kennisquiz {

    public int speelTijd;
    public int aantalGoedeAntwoorden;
    public int behaaldeScore;
    public Vraag huidigeVraag;
    public ArrayList<Vraag> quizvragen;
    public ArrayList<Thema> themas;
    public Thema gekozenThema;
    public ArrayList<Vragenlijst> vragenlijsten;
    public Vragenlijst gekozenVragenlijst;


    public Kennisquiz() {

        Account speler1 = new Speler("speler1", "wachtwoord", new Taal("Nederlands"));

        Thema sport = new Thema(1, "Sport");
        Thema muziek = new Thema(2, "muziek");

        Vragenlijst sportFormule1 = new Vragenlijst(1, 1, "SportFormule1");
        Vragenlijst sportHonkbal = new Vragenlijst(1, 2, "SportHonkbal");
        Vragenlijst muziekAlgemeen = new Vragenlijst(2, 3, "MuziekAlgemeen");

        ArrayList<Vraag> vragenSportFormule1 = new ArrayList<>();
        ArrayList<Vraag> vragenSportHonkbal = new ArrayList<>();
        ArrayList<Vraag> vragenMuziekAlgemeen = new ArrayList<>();

        ArrayList<String> vraag1Antwoorden = new ArrayList<>();
        vraag1Antwoorden.add("Michael Schumacher");
        vraag1Antwoorden.add("Schumacher");

        ArrayList<String> vraag2Antwoorden = new ArrayList<>();
        vraag2Antwoorden.add("Nico Rosberg");
        vraag2Antwoorden.add("Rosberg");

        ArrayList<String> vraag3Antwoorden = new ArrayList<>();
        vraag3Antwoorden.add("Pastor Maldonado");
        vraag3Antwoorden.add("Crashtor Maldonado");

        ArrayList<String> vraag4FouteAntwoorden = new ArrayList<>();
        vraag4FouteAntwoorden.add("Monza");
        vraag4FouteAntwoorden.add("Jerez");
        vraag4FouteAntwoorden.add("Paul Ricard");

        ArrayList<String> vraag5Antwoorden = new ArrayList<>();
        vraag5Antwoorden.add("Brawn GP");
        vraag5Antwoorden.add("Brawn");

        ArrayList<String> vraag6FouteAntwoorden = new ArrayList<>();
        vraag6FouteAntwoorden.add("Max Verstappen");
        vraag6FouteAntwoorden.add("Daniel Ricciardo");
        vraag6FouteAntwoorden.add("Daniil Kvyat");
        vraag6FouteAntwoorden.add("Jean-Eric Vergne");

        ArrayList<String> vraag7Antwoorden = new ArrayList<>();
        vraag7Antwoorden.add("2012");

        ArrayList<String> vraag8Antwoorden = new ArrayList<>();
        vraag8Antwoorden.add("Valencia");
        vraag8Antwoorden.add("Europa");

        ArrayList<String> vraag9Antwoorden = new ArrayList<>();
        vraag9Antwoorden.add("Drag Reduction System");

        ArrayList<String> vraag10Antwoorden = new ArrayList<>();
        vraag10Antwoorden.add("Kinetic Energy Recovery System");

        ArrayList<String> vraag11Antwoorden = new ArrayList<>();
        vraag11Antwoorden.add("2014");

        ArrayList<String> vraag12Antwoorden = new ArrayList<>();
        vraag12Antwoorden.add("Jacques Villeneuve");
        vraag12Antwoorden.add("Villeneuve");

        ArrayList<String> vraag13Antwoorden = new ArrayList<>();
        vraag13Antwoorden.add("Maranello");

        ArrayList<String> vraag14FouteAntwoorden = new ArrayList<>();
        vraag14FouteAntwoorden.add("Lewis Hamilton");
        vraag14FouteAntwoorden.add("Fernando Alonso");
        vraag14FouteAntwoorden.add("Pastor Maldonado");
        vraag14FouteAntwoorden.add("Jean-Eric Vergne");
        vraag14FouteAntwoorden.add("Kamui Kobayashi");

        ArrayList<String> vraag15Antwoorden = new ArrayList<>();
        vraag15Antwoorden.add("Melbourne");
        vraag15Antwoorden.add("Albert Park");

///////////////////////////////////////////////////////////////////////////////

        ArrayList<String> vraag31Antwoorden = new ArrayList<>();
        vraag31Antwoorden.add("Freddie Mercurie");
        vraag31Antwoorden.add("Freddy Mercurie");

        ArrayList<String> vraag32Antwoorden = new ArrayList<>();
        vraag32Antwoorden.add("Billy Joel");
        vraag32Antwoorden.add("Billie Joel");

        ArrayList<String> vraag33FouteAntwoorden = new ArrayList<>();
        vraag33FouteAntwoorden.add("Elvis Presley");
        vraag33FouteAntwoorden.add("Bob Dylan");
        vraag33FouteAntwoorden.add("Bob Marley");
        vraag33FouteAntwoorden.add("John Lennon");

        ArrayList<String> vraag34Antwoorden = new ArrayList<>();
        vraag34Antwoorden.add("John Mayer");
        vraag34Antwoorden.add("John Mayor");

        ArrayList<String> vraag35Antwoorden = new ArrayList<>();
        vraag35Antwoorden.add("6");
        vraag35Antwoorden.add("zes");

        ArrayList<String> vraag36Antwoorden = new ArrayList<>();
        vraag36Antwoorden.add("Whenever Wherever");
        vraag36Antwoorden.add("Whenever whenever");

        ArrayList<String> vraag37Antwoorden = new ArrayList<>();
        vraag37Antwoorden.add("Take That");

        ArrayList<String> vraag38Antwoorden = new ArrayList<>();
        vraag38Antwoorden.add("Coldplay");

        ArrayList<String> vraag39Antwoorden = new ArrayList<>();
        vraag39Antwoorden.add("Amy Winehouse");
        vraag39Antwoorden.add("Amy Whinehouse");

        ArrayList<String> vraag40FouteAntwoorden = new ArrayList<>();
        vraag40FouteAntwoorden.add("Duits");
        vraag40FouteAntwoorden.add("Zwitsers");

        ArrayList<String> vraag41Antwoorden = new ArrayList<>();
        vraag41Antwoorden.add("New York");
        vraag41Antwoorden.add("NYC");
        vraag41Antwoorden.add("NY");
        vraag41Antwoorden.add("New York City");

        ArrayList<String> vraag42Antwoorden = new ArrayList<>();
        vraag42Antwoorden.add("Eminem");

        ArrayList<String> vraag43Antwoorden = new ArrayList<>();
        vraag43Antwoorden.add("Black Eyed Peas");
        vraag43Antwoorden.add("Black Eyed Piece");

        ArrayList<String> vraag44Antwoorden = new ArrayList<>();
        vraag44Antwoorden.add("Country");

        ArrayList<String> vraag45Antwoorden = new ArrayList<>();
        vraag45Antwoorden.add("Bob Marley");

        Vraag vraag1 = new OpenVraag(1, 1, "Wie is in de Formule 1 de meeste keren wereldkampioen geworden?", vraag1Antwoorden);
        Vraag vraag2 = new OpenVraag(2, 1, "Welke coureur werd in 2016 ten koste van Lewis Hamilton wereldkampioen?", vraag2Antwoorden);
        Vraag vraag3 = new OpenVraag(3, 1, "Wie won in 2012 voor Williams de grand prix van Spanje?", vraag3Antwoorden);
        Vraag vraag4 = new MeerkeuzeVraag(4, 1, "Op welk circuit verongelukte Ayrton Senna?", "Imola", vraag4FouteAntwoorden);
        Vraag vraag5 = new OpenVraag(5, 1, "Welk team werd in 2009, in hun enige jaar in de sport, wereldkampioen?", vraag5Antwoorden);
        Vraag vraag6 = new MeerkeuzeVraag(6, 1, "Wie is de enige coureur in de geschiedenis die voor Toro Rosso een race heeft gewonnen?", "Sebastian Vettel", vraag6FouteAntwoorden);
        Vraag vraag7 = new OpenVraag(7, 1, "In welk jaar kwam Mercedes terug in de formule 1 als constructeur?", vraag7Antwoorden);
        Vraag vraag8 = new OpenVraag(8, 1, "Op welk circuit ging Mark Webber 'airborne' in 2010?", vraag8Antwoorden);
        Vraag vraag9 = new OpenVraag(9, 1, "Waar staat de afkorting 'DRS' voor in de formule 1?", vraag9Antwoorden);
        Vraag vraag10 = new OpenVraag(10, 1, "Waar staat in de formule 1 de afkorting voor de (niet meer gebruikte) techniek 'KERS' voor?", vraag10Antwoorden);
        Vraag vraag11 = new OpenVraag(11, 1, "In welk jaar maakten de 1.6L turbomotoren hun debuut in de formule 1", vraag11Antwoorden);
        Vraag vraag12 = new OpenVraag(12, 1, "Welke Canadese coureur werd en 1997 wereldkampioen?", vraag12Antwoorden);
        Vraag vraag13 = new OpenVraag(13, 1, "In welke Italiaanse plaats is de fabriek van Scuderia Ferrari gevestigd?", vraag13Antwoorden);
        Vraag vraag14 = new MeerkeuzeVraag(14, 1, "Welke coureur veroorzaakte de enorme startcrash in Spa in 2012?", "Romain Grosjean", vraag14FouteAntwoorden);
        Vraag vraag15 = new OpenVraag(15, 1, "In welke stad wordt de afgelopen jaren traditioneel de eerste race van het seizoen verreden?", vraag15Antwoorden);

        vragenSportFormule1.add(vraag1);
        vragenSportFormule1.add(vraag2);
        vragenSportFormule1.add(vraag3);
        vragenSportFormule1.add(vraag4);
        vragenSportFormule1.add(vraag5);
        vragenSportFormule1.add(vraag6);
        vragenSportFormule1.add(vraag7);
        vragenSportFormule1.add(vraag8);
        vragenSportFormule1.add(vraag9);
        vragenSportFormule1.add(vraag10);
        vragenSportFormule1.add(vraag11);
        vragenSportFormule1.add(vraag12);
        vragenSportFormule1.add(vraag13);
        vragenSportFormule1.add(vraag14);
        vragenSportFormule1.add(vraag15);


        Vraag vraag31 = new OpenVraag(31, 3, "Wie was de frontman van Queen?", vraag31Antwoorden);
        Vraag vraag32 = new OpenVraag(32, 3, "Welke zanger had in 1970 een hit met 'Piano Man'?", vraag32Antwoorden);
        Vraag vraag33 = new MeerkeuzeVraag(33, 3, "Welke zanger werd de King of Pop genoemd?", "Michael Jackson", vraag33FouteAntwoorden);
        Vraag vraag34 = new OpenVraag(34, 3, "Welke zanger bracht in 2012 het album 'Born and Raised' uit?", vraag34Antwoorden);
        Vraag vraag35 = new OpenVraag(35, 3, "Hoeveel snaren heeft een gitaar gewoonlijk?", vraag35Antwoorden);
        Vraag vraag36 = new OpenVraag(36, 3, "Met welk nummer brak zangeres Shakira in 2001 wereldwijd door?", vraag36Antwoorden);
        Vraag vraag37 = new OpenVraag(37, 3, "Bij welke popgroep zong Robbie Williams van 1990 – 1995?", vraag37Antwoorden);
        Vraag vraag38 = new OpenVraag(38, 3, "Welke Britse band vormen Chris Martin, Jon Buckland, Will Champion en Guy Berryman?", vraag38Antwoorden);
        Vraag vraag39 = new OpenVraag(39, 3, "Welke Britse zangeres had een hit in 2006 met 'Rehab'?", vraag39Antwoorden);
        Vraag vraag40 = new MeerkeuzeVraag(40, 3, "Welke nationaliteit had Mozart?", "Oostenrijks", vraag40FouteAntwoorden);
        Vraag vraag41 = new OpenVraag(41, 3, "In welke stad werd John Lennon vermoord?", vraag41Antwoorden);
        Vraag vraag42 = new OpenVraag(42, 3, "Met welke naam is Marshall Bruce Mathers III beter gekend?", vraag42Antwoorden);
        Vraag vraag43 = new OpenVraag(43, 3, "In welke band zingt zanger Will.i.am?", vraag43Antwoorden);
        Vraag vraag44 = new OpenVraag(44, 3, "Welke genre muziek wordt er normaal bij line-dancen gespeeld?", vraag44Antwoorden);
        Vraag vraag45 = new OpenVraag(45, 3, "Wie staat bekend als The King of Reggae?", vraag45Antwoorden);

        vragenMuziekAlgemeen.add(vraag31);
        vragenMuziekAlgemeen.add(vraag32);
        vragenMuziekAlgemeen.add(vraag33);
        vragenMuziekAlgemeen.add(vraag34);
        vragenMuziekAlgemeen.add(vraag35);
        vragenMuziekAlgemeen.add(vraag36);
        vragenMuziekAlgemeen.add(vraag37);
        vragenMuziekAlgemeen.add(vraag38);
        vragenMuziekAlgemeen.add(vraag39);
        vragenMuziekAlgemeen.add(vraag40);
        vragenMuziekAlgemeen.add(vraag41);
        vragenMuziekAlgemeen.add(vraag42);
        vragenMuziekAlgemeen.add(vraag43);
        vragenMuziekAlgemeen.add(vraag44);
        vragenMuziekAlgemeen.add(vraag45);
    }

    public void speelSpel(Vragenlijst lijst){

    }

    public void startTimer(){
//        ArrayList<String> antwoorden = new ArrayList<>();
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        antwoorden.add("asdf");
//        Vraag vraag1 = new OpenVraag(1, "asdfa", antwoorden);
//        Vraag vraag2 = new MeerkeuzeVraag(1, "asdf", "asdfasdf", antwoorden);
//
//        ArrayList<Vraag> vragen = new ArrayList<>();
//        vragen.add(vraag1);
//        vragen.add(vraag2);
    }

    public void stopTimer() {

    }

    public void controleerAntwoord(String goedeAntwoord, String input) {

    }

    public void controleerAntwoord(ArrayList<String> goedeAntwoorden, String input) {

    }

    public void getRandomQuizVragen(){

    }

    public void setHighScore(int behaaldeScore){

    }

    public void setThema(Thema thema){

    }

    public void setVragenlijst(Vragenlijst vragenlijst){

    }

    public void slaAntwoordOp(String input, Vraag vraag){

    }
}
