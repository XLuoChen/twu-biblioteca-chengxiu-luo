package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    Library library;

    Display display;

    public Display() {
    }

    public Display(Display display, Library library) {
        this();
        this.display = display;
        this.library = library;
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
        ArrayList<String> books = library.getBooks();
        for (String book : books) {
            System.out.println(book);
        }
    }

    public void checkoutBook() {
        String input = display.getUserInputOption();
        boolean isCheckoutBookSuccessfully = library.checkoutBook(Integer.parseInt(input));
        if (isCheckoutBookSuccessfully) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public void displayInformationWithUserInput() {
        String userInputOption = display.getUserInputOption();
        while (!userInputOption.equals("Q")) {

            switch (userInputOption) {
                case "1":
                    display.displayBooks();
                    break;
                case "2":
                    display.checkoutBook();
                    break;
                default:
                    display.displayInvalidMessage();
            }
            display.showMenu();
            userInputOption = display.getUserInputOption();
        }
    }
}
