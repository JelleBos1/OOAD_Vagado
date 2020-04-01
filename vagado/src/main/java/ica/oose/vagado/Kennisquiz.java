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

    public double speelTijd;
    public int aantalGoedeAntwoorden;
    public int behaaldeScore;
    public Speler speler;
    public ArrayList<Vraag> quizvragen;
    public ArrayList<Thema> themas;
    public String gekozenThema;
    public List<Vragenlijst> vragenlijsten;
    public Bezit bezit1;
    public Bezit bezit2;
    public String gekozenVragenlijst;
    List<Vragenlijst> vragenlijstenPerThema;
    List<Vraag> quizVragen = new ArrayList<>();
    ArrayList<Antwoord> antwoordenSpeler = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    StopWatch timer = new StopWatch();

    List<Vraag> gekozenVragen;

    public Kennisquiz() {
        SpelInitialisatie si = new SpelInitialisatie();
        themas = si.setThemas();
        speler = si.setSpeler();
        vragenlijsten = si.setVragenlijsten();
        quizvragen = si.setVragen();
    }

    public void speelSpel(){

        System.out.println("Welkom bij Vagado " + speler.getGebruikersnaam());

        kiesThema();
        kiesVragenlijst();
        shuffleVragen();
        speelVragen();

        speelTijd = ((double)timer.getTime() / 1000);
        System.out.println("Je hebt er " + speelTijd + " seconden over gedaan.");
        System.out.println("De behaalde score is " + berekenScore(4, speelTijd) + " punten");
    }

    public void printVraag(AtomicInteger index, String vraag){
        System.out.println("Vraag " + index + ": " + vraag);
    }

    public void kiesThema(){
        System.out.println("Beschikbare thema's: ");
        themas.forEach((thema) -> System.out.println("- " + thema.getNaam()));

        System.out.println("Kies een thema");
        gekozenThema = scanner.nextLine();

        vragenlijstenPerThema = vragenlijsten.stream().filter(vragenlijst -> vragenlijst.getThema().equals(gekozenThema)).collect(Collectors.toList());

        if (vragenlijstenPerThema.size() == 0){
            System.out.println("Kies een geldig thema");
            kiesThema();
        }
    }

    public void kiesVragenlijst(){
        System.out.println("De besckikbare vragenlijsten binnen het thema " + gekozenThema + " zijn: ");
        vragenlijstenPerThema.forEach((vragenlijst) -> System.out.println("- " + vragenlijst.getNaam()));

        System.out.println("Kies een vragenlijst");
        gekozenVragenlijst = scanner.nextLine();

        System.out.println("Je hebt gekozen voor " + gekozenVragenlijst);

        vulVragenPerVragenlijst(gekozenVragenlijst);
    }

    public void shuffleVragen(){
        Collections.shuffle(gekozenVragen);

        for (int i = 0; i<AANTAL_QUIZ_VRAGEN; i++){
//            System.out.println("Id: "+ quizVragen.get(i).getId() + ", " + quizVragen.get(i).getVraag());
            quizVragen.add(gekozenVragen.get(i));
        }
    }

    public void speelVragen(){
        timer.start();

        AtomicInteger index = new AtomicInteger(1);

        quizVragen.forEach((vraag) -> {

            if (vraag instanceof OpenVraag){
//                System.out.println("Vraag " + index + ": " + vraag.getVraag());
                printVraag(index, vraag.getVraag());

                ArrayList<String> antwoorden = ((OpenVraag) vraag).getGoedeAntwoorden();
                antwoorden.forEach((antwoord) -> System.out.println("Antwoord: " + antwoord.toString()));

                String antwoord = scanner.nextLine();
                if (antwoorden.contains(antwoord)){
                    printAntwoordGoed();
                    aantalGoedeAntwoorden++;
                }
                else {
                    printAntwoordFout();
                }
                antwoordenSpeler.add(new Antwoord(vraag.getId(), antwoord));
            }


            if (vraag instanceof MeerkeuzeVraag){
                ArrayList<String> mogelijkeAntwoorden = new ArrayList<>();
//                System.out.println("Vraag " + index + ": " + vraag.getVraag());
                printVraag(index, vraag.getVraag());
                ArrayList<String> fouteAntwoorden = ((MeerkeuzeVraag) vraag).getFouteAntwoorden();

                fouteAntwoorden.forEach((antwoord) -> mogelijkeAntwoorden.add(antwoord));

                String goedAntwoord = ((MeerkeuzeVraag) vraag).getGoedAntwoord();
                mogelijkeAntwoorden.add(goedAntwoord);

                Collections.shuffle(mogelijkeAntwoorden);

                mogelijkeAntwoorden.forEach((antwoord) -> System.out.println("- " + antwoord.toString()));


                String antwoord = scanner.nextLine();
                if (antwoord.equals(goedAntwoord)){
                    printAntwoordGoed();
                    aantalGoedeAntwoorden++;
                }
                else {
                    printAntwoordFout();
                }

                antwoordenSpeler.add(new Antwoord(vraag.getId(), antwoord));
            }


            index.getAndIncrement();
        });

        timer.stop();

    }

    public void printAntwoordGoed(){
        System.out.println("Dat antwoord is goed!");
    }

    public void printAntwoordFout(){
        System.out.println("Dat antwoord is helaas fout");
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

    public int berekenScore(int aantalGoedeAntwoorden, double speeltijd){
        int behaaldeScore = 0;
        if (aantalGoedeAntwoorden == AANTAL_QUIZ_VRAGEN){
            verhoogMunten(aantalGoedeAntwoorden);
        behaaldeScore += 50;       // bonus alle vragen goed
        }
        behaaldeScore += aantalGoedeAntwoorden * 10; // punten berekening
        behaaldeScore += (int)(100-speeltijd); //bonuspunten speeltijd

        ArrayList<Bezit> bezitten = speler.getBezitten();
        List<Bezit> bezit;
        bezit = bezitten.stream().filter(bezitVanVragenlijst -> bezitVanVragenlijst.getVragenlijst().equals(gekozenVragenlijst)).collect(Collectors.toList());

        if (behaaldeScore > bezit.get(0).getHighscore()){
            bezit.get(0).setHighscore(behaaldeScore);
        };

        bezit.forEach((bezit1) -> System.out.println("- Vragenlijst " + bezit1.getVragenlijst() + ", highscore: " + bezit1.getHighscore()));

        return behaaldeScore;
    }

    public void verhoogMunten (int aantalGoedeAntwoorden) {
        speler.voegMuntenToe(ALLES_GOED_MUNTEN_PRIJS); // hoog munten op
    }

    public void vulVragenPerVragenlijst(String vragenlijst){
        gekozenVragen = quizvragen.stream().filter(vraag -> vraag.getVragenlijst().getNaam().equals(vragenlijst)).collect(Collectors.toList());

        if (gekozenVragen.size() == 0){
            kiesVragenlijst();
        }
    }
}
