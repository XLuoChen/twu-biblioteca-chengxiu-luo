package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        Library library = new Library();
        ArrayList<String> books = library.getBooks();
        for (String book : books) {
            System.out.println(book);
        }
    }
}
