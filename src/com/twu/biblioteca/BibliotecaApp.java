package com.twu.biblioteca;

public class BibliotecaApp {

    public void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public void showMenu() {
        System.out.println("\t---------------------");
        System.out.println("\t\t1. List options");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        bibliotecaApp.showMenu();

        Display display = new Display();
        display.displayInformationWithUserInput();
    }
}
