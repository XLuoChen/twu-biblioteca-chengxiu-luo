package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    Display display;

    public Display() {
    }

    public Display(Display display) {
        super();
        this.display = display;
    }

    public int getUserInputOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void displayInvalidMessage() {
        System.out.println("Select a valid option!");
    }

    public void displayBooks() {
        Library library = new Library();
        ArrayList<String> books = library.getBooks();
        for (String book : books) {
            System.out.println(book);
        }
    }

    public void displayInformationWithUserInput() {
        switch (getUserInputOption()) {
            case 1:
                displayBooks();
                break;
            default:
                displayInvalidMessage();
        }
    }
}
