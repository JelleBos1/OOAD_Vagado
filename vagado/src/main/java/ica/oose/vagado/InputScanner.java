package ica.oose.vagado;

import java.util.Scanner;

public class InputScanner extends Input {

    public Scanner scan = new Scanner(System.in);

    @Override
    public String getInput() {
        return scan.nextLine();
    }

}
