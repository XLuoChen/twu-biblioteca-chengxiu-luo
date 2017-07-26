package com.twu.biblioteca;

public class BibliotecaApp {

    public void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        Display display = new Display(new Display());
        display.showMenu();
        display.displayInformationWithUserInput();
    }
}
