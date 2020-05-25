package ica.oose.vagado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ica.oose.vagado.Vagado.PRINTER;

public class SpelInitialisatie {

    private List<Vraag> gekozenVragen;

    Thema sport = new Thema("Sport");
    Thema muziek = new Thema("Muziek");

    Vragenlijst vragenlijstSportFormule1 = new Vragenlijst(sport, "Sport - Formule 1", 50);
    Vragenlijst vragenlijstSportHonkbal = new Vragenlijst(sport, "Sport - Honkbal", 50);
    Vragenlijst vragenlijstMuziekAlgemeen = new Vragenlijst(muziek, "Muziek - Algemeen", 50);

    public ArrayList<Vragenlijst> getVragenlijsten(){
        ArrayList<Vragenlijst> vragenlijsten = new ArrayList<>();

        vragenlijsten.add(vragenlijstSportFormule1);
        vragenlijsten.add(vragenlijstSportHonkbal);
        vragenlijsten.add(vragenlijstMuziekAlgemeen);

        return vragenlijsten;
    }

    public ArrayList<Vraag> getVragen(){

        ArrayList<Vraag> vragen = new ArrayList<>();

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

        ArrayList<String> vraag16FouteAntwoorden = new ArrayList<>();
        vraag16FouteAntwoorden.add("NBA");
        vraag16FouteAntwoorden.add("NFL");
        vraag16FouteAntwoorden.add("NHL");

        ArrayList<String> vraag17Antwoorden = new ArrayList<>();
        vraag17Antwoorden.add("Major League Baseball");

        ArrayList<String> vraag18Antwoorden = new ArrayList<>();
        vraag18Antwoorden.add("Werper");
        vraag18Antwoorden.add("Pitcher");

        ArrayList<String> vraag19Antwoorden = new ArrayList<>();
        vraag19Antwoorden.add("3");
        vraag19Antwoorden.add("Drie");

        ArrayList<String> vraag20FouteAntwoorden = new ArrayList<>();
        vraag20FouteAntwoorden.add("7");
        vraag20FouteAntwoorden.add("8");
        vraag20FouteAntwoorden.add("11");

        ArrayList<String> vraag21Antwoorden = new ArrayList<>();
        vraag21Antwoorden.add("Aangewezen slagman");
        vraag21Antwoorden.add("Designated hitter");

        ArrayList<String> vraag22FouteAntwoorden = new ArrayList<>();
        vraag22FouteAntwoorden.add("2");
        vraag22FouteAntwoorden.add("4");
        vraag22FouteAntwoorden.add("5");

        ArrayList<String> vraag23Antwoorden = new ArrayList<>();
        vraag23Antwoorden.add("Thuisplaat");
        vraag23Antwoorden.add("Thuis plaat");
        vraag23Antwoorden.add("Home plate");
        vraag23Antwoorden.add("Homeplate");

        ArrayList<String> vraag24FouteAntwoorden = new ArrayList<>();
        vraag24FouteAntwoorden.add("Slaan");
        vraag24FouteAntwoorden.add("Stelen");
        vraag24FouteAntwoorden.add("Beuken");

        ArrayList<String> vraag25FouteAntwoorden = new ArrayList<>();
        vraag25FouteAntwoorden.add("Shutout");
        vraag25FouteAntwoorden.add("Clean sweep");
        vraag25FouteAntwoorden.add("Touchdown");

        ArrayList<String> vraag26FouteAntwoorden = new ArrayList<>();
        vraag26FouteAntwoorden.add("LA Dodgers");
        vraag26FouteAntwoorden.add("Boston Red Sox");
        vraag26FouteAntwoorden.add("LA Angels");

        ArrayList<String> vraag27FouteAntwoorden = new ArrayList<>();
        vraag27FouteAntwoorden.add("Detroit");
        vraag27FouteAntwoorden.add("Seattle");
        vraag27FouteAntwoorden.add("Miami");

        ArrayList<String> vraag28FouteAntwoorden = new ArrayList<>();
        vraag28FouteAntwoorden.add("LA Dodgers");
        vraag28FouteAntwoorden.add("New York Yankees");
        vraag28FouteAntwoorden.add("Houston Astros");

        ArrayList<String> vraag29FouteAntwoorden = new ArrayList<>();
        vraag29FouteAntwoorden.add("Big home run");
        vraag29FouteAntwoorden.add("Slam dunk");
        vraag29FouteAntwoorden.add("Hail mary");

        ArrayList<String> vraag30FouteAntwoorden = new ArrayList<>();
        vraag30FouteAntwoorden.add("Double handed");
        vraag30FouteAntwoorden.add("Switcher");
        vraag30FouteAntwoorden.add("Mad man");

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

        vragen.add(new OpenVraag(1, vragenlijstSportFormule1, "Wie is in de Formule 1 de meeste keren wereldkampioen geworden?", vraag1Antwoorden));
        vragen.add(new OpenVraag(2, vragenlijstSportFormule1, "Welke coureur werd in 2016 ten koste van Lewis Hamilton wereldkampioen?", vraag2Antwoorden));
        vragen.add(new OpenVraag(3, vragenlijstSportFormule1, "Wie won in 2012 voor Williams de grand prix van Spanje?", vraag3Antwoorden));
        vragen.add(new MeerkeuzeVraag(4, vragenlijstSportFormule1, "Op welk circuit verongelukte Ayrton Senna?", "Imola", vraag4FouteAntwoorden));
        vragen.add(new OpenVraag(5, vragenlijstSportFormule1, "Welk team werd in 2009, in hun enige jaar in de sport, wereldkampioen?", vraag5Antwoorden));
        vragen.add(new MeerkeuzeVraag(6, vragenlijstSportFormule1, "Wie is de enige coureur in de geschiedenis die voor Toro Rosso een race heeft gewonnen?", "Sebastian Vettel", vraag6FouteAntwoorden));
        vragen.add(new OpenVraag(7, vragenlijstSportFormule1, "In welk jaar kwam Mercedes terug in de formule 1 als constructeur?", vraag7Antwoorden));
        vragen.add(new OpenVraag(8, vragenlijstSportFormule1, "Op welk circuit ging Mark Webber 'airborne' in 2010?", vraag8Antwoorden));
        vragen.add(new OpenVraag(9, vragenlijstSportFormule1, "Waar staat de afkorting 'DRS' voor in de formule 1?", vraag9Antwoorden));
        vragen.add(new OpenVraag(10, vragenlijstSportFormule1, "Waar staat in de formule 1 de afkorting voor de (niet meer gebruikte) techniek 'KERS' voor?", vraag10Antwoorden));
        vragen.add(new OpenVraag(11, vragenlijstSportFormule1, "In welk jaar maakten de 1.6L turbomotoren hun debuut in de formule 1", vraag11Antwoorden));
        vragen.add(new OpenVraag(12, vragenlijstSportFormule1, "Welke Canadese coureur werd en 1997 wereldkampioen?", vraag12Antwoorden));
        vragen.add(new OpenVraag(13, vragenlijstSportFormule1, "In welke Italiaanse plaats is de fabriek van Scuderia Ferrari gevestigd?", vraag13Antwoorden));
        vragen.add(new MeerkeuzeVraag(14, vragenlijstSportFormule1, "Welke coureur veroorzaakte de enorme startcrash in Spa in 2012?", "Romain Grosjean", vraag14FouteAntwoorden));
        vragen.add(new OpenVraag(15, vragenlijstSportFormule1, "In welke stad wordt de afgelopen jaren traditioneel de eerste race van het seizoen verreden?", vraag15Antwoorden));

        vragen.add(new MeerkeuzeVraag(16, vragenlijstSportHonkbal, "Wat is de afkorting van het hoogste professionele honkbal niveau in Noord-Amerika?", "MLB", vraag16FouteAntwoorden));
        vragen.add(new OpenVraag(17, vragenlijstSportHonkbal, "Waarvoor staat de afkorting MLB?", vraag17Antwoorden));
        vragen.add(new OpenVraag(18, vragenlijstSportHonkbal, "Wat is de naam van de speler die de bal naar de slagman gooit?", vraag18Antwoorden));
        vragen.add(new OpenVraag(19, vragenlijstSportHonkbal, "Hoeveel spelers moeten er uit gemaakt worden voordat er gewisseld wordt?", vraag19Antwoorden));
        vragen.add(new MeerkeuzeVraag(20, vragenlijstSportHonkbal, "Hoeveel veldposities zijn er?", "9", vraag20FouteAntwoorden));
        vragen.add(new OpenVraag(21, vragenlijstSportHonkbal, "Hoe heet de slagman die veldspeler als slagman kan vervangen?", vraag21Antwoorden));
        vragen.add(new MeerkeuzeVraag(22, vragenlijstSportHonkbal, "Hoeveel buitenvelders staan er in een veldopstelling", "3", vraag22FouteAntwoorden));
        vragen.add(new OpenVraag(23, vragenlijstSportHonkbal, "Hoe heet het honk waar je als slagman begint en (hopelijk) eindigt?", vraag23Antwoorden));
        vragen.add(new MeerkeuzeVraag(24, vragenlijstSportHonkbal, "Wat mag er niet in honkbal?", "Tackelen", vraag24FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(25, vragenlijstSportHonkbal, "Hoe heet het wanneer een werper direct naar een honk gooit i.p.v. de thuisplaat?", "Pickoff", vraag25FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(26, vragenlijstSportHonkbal, "Welk professionele honkbal team heeft specifieke regels over haarlengte en baardgroei voor zijn spelers?", "New York Yankees", vraag26FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(27, vragenlijstSportHonkbal, "Uit welke stad komt het team de ... Blue Jays?", "Toronto", vraag27FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(28, vragenlijstSportHonkbal, "Welk team won de World Series in 2019?", "Washington Nationals", vraag28FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(29, vragenlijstSportHonkbal, "Wat is de naam voor een homerun wanneer alle ander honken bezet zijn?", "Grand Slam", vraag29FouteAntwoorden));
        vragen.add(new MeerkeuzeVraag(30, vragenlijstSportHonkbal, "Wat is de naam voor een slagman die rechts en links kan slaan?", "Switch hitter", vraag30FouteAntwoorden));

        vragen.add(new OpenVraag(31, vragenlijstMuziekAlgemeen, "Wie was de frontman van Queen?", vraag31Antwoorden));
        vragen.add(new OpenVraag(32, vragenlijstMuziekAlgemeen, "Welke zanger had in 1970 een hit met 'Piano Man'?", vraag32Antwoorden));
        vragen.add(new MeerkeuzeVraag(33, vragenlijstMuziekAlgemeen, "Welke zanger werd de King of Pop genoemd?", "Michael Jackson", vraag33FouteAntwoorden));
        vragen.add(new OpenVraag(34, vragenlijstMuziekAlgemeen, "Welke zanger bracht in 2012 het album 'Born and Raised' uit?", vraag34Antwoorden));
        vragen.add(new OpenVraag(35, vragenlijstMuziekAlgemeen, "Hoeveel snaren heeft een gitaar gewoonlijk?", vraag35Antwoorden));
        vragen.add(new OpenVraag(36, vragenlijstMuziekAlgemeen, "Met welk nummer brak zangeres Shakira in 2001 wereldwijd door?", vraag36Antwoorden));
        vragen.add(new OpenVraag(37, vragenlijstMuziekAlgemeen, "Bij welke popgroep zong Robbie Williams van 1990 – 1995?", vraag37Antwoorden));
        vragen.add(new OpenVraag(38, vragenlijstMuziekAlgemeen, "Welke Britse band vormen Chris Martin, Jon Buckland, Will Champion en Guy Berryman?", vraag38Antwoorden));
        vragen.add(new OpenVraag(39, vragenlijstMuziekAlgemeen, "Welke Britse zangeres had een hit in 2006 met 'Rehab'?", vraag39Antwoorden));
        vragen.add(new MeerkeuzeVraag(40, vragenlijstMuziekAlgemeen, "Welke nationaliteit had Mozart?", "Oostenrijks", vraag40FouteAntwoorden));
        vragen.add(new OpenVraag(41, vragenlijstMuziekAlgemeen, "In welke stad werd John Lennon vermoord?", vraag41Antwoorden));
        vragen.add(new OpenVraag(42, vragenlijstMuziekAlgemeen, "Met welke naam is Marshall Bruce Mathers III beter gekend?", vraag42Antwoorden));
        vragen.add(new OpenVraag(43, vragenlijstMuziekAlgemeen, "In welke band zingt zanger Will.i.am?", vraag43Antwoorden));
        vragen.add(new OpenVraag(44, vragenlijstMuziekAlgemeen, "Welke genre muziek wordt er normaal bij line-dancen gespeeld?", vraag44Antwoorden));
        vragen.add(new OpenVraag(45, vragenlijstMuziekAlgemeen, "Wie staat bekend als The King of Reggae?", vraag45Antwoorden));

        return vragen;
    }

    public void vulVragenPerVragenlijst(Vragenlijst vragenlijst){
        gekozenVragen = getVragen().stream().filter(vraag -> vraag.getVragenlijst().getNaam().equals(vragenlijst.getNaam())).collect(Collectors.toList());

        if (gekozenVragen.size() == 0){
            PRINTER.printToScreen("Vragenlijst niet gevonden. Start de quiz opnieuw met een bestaande vragenlijst.");
            throw new Error("Vragenlijst niet gevonden");
        }
    }

    public List<Vraag> getGekozenVragen(){
        return gekozenVragen;
    }

}
