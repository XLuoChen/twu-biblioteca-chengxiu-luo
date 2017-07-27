package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    Display display;

    public Display() {
    }

    public Display(Display display) {
        this();
        this.display = display;
    }

    public void showMenu() {
        System.out.println("\t-----------------------");
        System.out.println("\t\t1. List options");
        System.out.println("\t\t(Input 'Q' to quit)");
        System.out.println("\t-----------------------");
    }

    public String getUserInputOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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
        String userInputOption = display.getUserInputOption();
        while (!userInputOption.equals("Q")) {

            switch (userInputOption) {
                case "1":
                    display.displayBooks();
                    break;
                default:
                    display.displayInvalidMessage();
            }
            display.showMenu();
            userInputOption = display.getUserInputOption();
        }
    }
}
