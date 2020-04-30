package ica.oose.vagado;

import org.apache.commons.lang3.time.StopWatch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ica.oose.vagado.SpelInitialisatie.AANTAL_QUIZ_VRAGEN;
import static ica.oose.vagado.SpelInitialisatie.ALLES_GOED_MUNTEN_PRIJS;

public class Kennisquiz {

    private double speelTijd;
    private int aantalGoedeAntwoorden;
    private Speler speler;
    private ArrayList<Vraag> alleQuizvragen;
    private ArrayList<Thema> themas;
    private String gekozenThema;
    private List<Vragenlijst> vragenlijsten;
    private String gekozenVragenlijst;
    private List<Vragenlijst> vragenlijstenPerThema;
    private List<Vraag> quizVragen = new ArrayList<>();
    private ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();
    private List<Vraag> gekozenVragen;
    private Puntentelling puntentellingVagado;

    Scanner scanner = new Scanner(System.in);
    StopWatch timer = new StopWatch();
    SpelInitialisatie si = new SpelInitialisatie();


    public Kennisquiz() {

        themas = si.setThemas();
        speler = si.setSpeler();
        vragenlijsten = si.setVragenlijsten();
        alleQuizvragen = si.setVragen();
        puntentellingVagado = new PuntentellingVagado();
    }

    public void speelSpel(){

        print("Welkom bij Vagado " + speler.getGebruikersnaam());

        kiesThema();
        kiesVragenlijst();

        printHeader("DE QUIZ START NU");

        speelVragen(gekozenVragenlijst);

        printHeader("SCORE");

        speelTijd = ((double)timer.getTime() / 1000);
        print("Je hebt er " + speelTijd + " seconden over gedaan.");
        print("De behaalde score is " + puntentellingVagado.berekenScore(aantalGoedeAntwoorden, speelTijd) + " punten");
        verhoogMunten(aantalGoedeAntwoorden);
        setHighScore(puntentellingVagado.berekenScore(aantalGoedeAntwoorden, speelTijd));
        slaAntwoordenOp();
    }

    public void print(String text){
        System.out.println(text);
    }

    public void printVraag(AtomicInteger index, String vraag){
        print("Vraag " + index + ": " + vraag);
    }

    public void printHeader(String header){
        print("\n");
        print("////////////////////////////////////////" + header + "////////////////////////////////////////");
        print("\n");
    }

    public void kiesThema(){
        print("Beschikbare thema's: ");
        themas.forEach((thema) -> print("- " + thema.getNaam()));

        print("Kies een thema");
        setThema(scanner.nextLine());

        vragenlijstenPerThema = vragenlijsten.stream().filter(vragenlijst -> vragenlijst.getThema().equals(gekozenThema)).collect(Collectors.toList());

        if (vragenlijstenPerThema.size() == 0){
            print("Dat thema bestaat niet. Kies een van de beschikbare thema's");
            kiesThema();
        }
    }

    public void kiesVragenlijst(){
        print("De besckikbare vragenlijsten binnen het thema " + gekozenThema + " zijn: ");
        vragenlijstenPerThema.forEach((vragenlijst) -> print("- " + vragenlijst.getNaam()));

        print("Kies een vragenlijst");
        setVragenlijst(scanner.nextLine());

        print("Je hebt gekozen voor " + gekozenVragenlijst);

    }

    public void getRandomQuizVragen(){
        Collections.shuffle(gekozenVragen);

        for (int i = 0; i<AANTAL_QUIZ_VRAGEN; i++){
            quizVragen.add(gekozenVragen.get(i));
        }
    }

    public void speelVragen(String vragenlijst){

        vulVragenPerVragenlijst(vragenlijst);
        getRandomQuizVragen();

        timer.start();

        AtomicInteger index = new AtomicInteger(1);

        quizVragen.forEach((vraag) -> {
            if (vraag instanceof OpenVraag){
                printVraag(index, vraag.getVraag());

                ArrayList<String> antwoorden = ((OpenVraag) vraag).getGoedeAntwoorden();
//                antwoorden.forEach((antwoord) -> print("Antwoord: " + antwoord));

                String antwoord = scanner.nextLine();
                if (antwoorden.contains(antwoord)){
                    printAntwoordGoed();
                    aantalGoedeAntwoorden++;
                }
                else {
                    printAntwoordFout();
                }

                slaAntwoordOp(vraag.getId(), antwoord);
            }

            if (vraag instanceof MeerkeuzeVraag){
                ArrayList<String> mogelijkeAntwoorden = new ArrayList<>();
                printVraag(index, vraag.getVraag());
                ArrayList<String> fouteAntwoorden = ((MeerkeuzeVraag) vraag).getFouteAntwoorden();

                fouteAntwoorden.forEach((antwoord) -> mogelijkeAntwoorden.add(antwoord));

                String goedAntwoord = ((MeerkeuzeVraag) vraag).getGoedAntwoord();
                mogelijkeAntwoorden.add(goedAntwoord);

                Collections.shuffle(mogelijkeAntwoorden);

                mogelijkeAntwoorden.forEach((antwoord) -> print("- " + antwoord));

                String antwoord = scanner.nextLine();
                if (antwoord.equals(goedAntwoord)){
                    printAntwoordGoed();
                    aantalGoedeAntwoorden++;
                }
                else {
                    printAntwoordFout();
                }

                slaAntwoordOp(vraag.getId(), antwoord);

            }


            index.getAndIncrement();
        });

        timer.stop();

    }

    public void printAntwoordGoed(){
        print("Dat antwoord is goed!");
        print("\n");
    }

    public void printAntwoordFout(){
        print("Dat antwoord is helaas fout");
        print("\n");
    }

    public void setHighScore(int behaaldeScore){
        ArrayList<Bezit> bezitten = speler.getBezitten();
        List<Bezit> bezit;
        bezit = bezitten.stream().filter(bezitVanVragenlijst -> bezitVanVragenlijst.getVragenlijst().equals(gekozenVragenlijst)).collect(Collectors.toList());

        print("Oude highscore: " + bezit.get(0).getHighscore() + " punten");

        if (behaaldeScore > bezit.get(0).getHighscore()){
            bezit.get(0).setHighscore(behaaldeScore);
            print("Gefeliciteerd, je hebt een nieuwe highscore behaald voor deze vragenlijst.");
            print("Nieuwe highscore: " + behaaldeScore + " punten");
        };

    }

    public void slaAntwoordenOp(){
        GegevenAntwoorden gegevenAntwoorden = new GegevenAntwoorden(speler.getGebruikersnaam(), aantalGoedeAntwoorden, speelTijd, antwoordenSpeler);
    }

    public void setThema(String thema){
        gekozenThema = thema;
    }

    public void setVragenlijst(String vragenlijst){
        gekozenVragenlijst = vragenlijst;
    }

    public void slaAntwoordOp(int vraagId, String antwoord){
        antwoordenSpeler.add(new Antwoord(vraagId, antwoord));
    }

    public void verhoogMunten (int aantalGoedeAntwoorden) {
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            speler.voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS); // hoog munten op
        }
    }

    public void vulVragenPerVragenlijst(String vragenlijst){
        gekozenVragen = alleQuizvragen.stream().filter(vraag -> vraag.getVragenlijst().getNaam().equals(vragenlijst)).collect(Collectors.toList());

        if (gekozenVragen.size() == 0){
            kiesVragenlijst();
        }
    }
}
