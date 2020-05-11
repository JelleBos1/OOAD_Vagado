package ica.oose.vagado;

public class PrinterConsole extends Printer {

    @Override
    public void printToScreen(String message) {
        System.out.println(message);
    }

    @Override
    public void printHeaderToScreen(String message) {
        System.out.println("\n");
        System.out.println("////////////////////////////////////////" + message + "////////////////////////////////////////");
        System.out.println("\n");
    }
}
