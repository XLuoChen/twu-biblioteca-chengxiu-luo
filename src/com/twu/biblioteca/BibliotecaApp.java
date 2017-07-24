package com.twu.biblioteca;

public class BibliotecaApp {

    String printWelcomeMessage(String message) {
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage("Welcome to BibliotecaApp");
    }
}
