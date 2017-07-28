package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    public void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        Menu menu = new Menu(new Library(), new Display(), new PrintStream(System.out));
        menu.menu();
    }
}
