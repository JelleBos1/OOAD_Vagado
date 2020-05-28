package ica.oose.vagado;

import java.util.ArrayList;
import java.util.List;

public interface IQuizData {

    ArrayList<Vraag> getVragen();
    ArrayList<Vragenlijst> getVragenlijsten();
    List<Vraag> filterVragen(Vragenlijst vragenlijst);
}
