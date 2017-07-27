package com.twu.biblioteca;

public class BibliotecaApp {

    public void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        Menu menu = new Menu(new Library(),new Display());
        menu.menu();
    }
}
