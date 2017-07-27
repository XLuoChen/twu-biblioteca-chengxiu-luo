package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private Library library;
    private Display display;
    private String userInput;

    Menu(Library library, Display display) {
        this.library = library;
        this.display = display;
    }

    public void showMenu() {
        System.out.println("\t-----------------------");
        System.out.println("\t\t1. List options");
        System.out.println("\t\t2. Check out book");
        System.out.println("\t\t(Input 'Q' to quit)");
        System.out.println("\t-----------------------");
    }

    private void displayInvalidMessage() {
        System.out.println("Select a valid option!");
    }

    private void displayBooks() {
        ArrayList<String> books = library.getBooks();
        for (String book : books) {
            System.out.println(book);
        }
    }

    private void checkoutBook() {
        System.out.println("Please input the number of you want check out:");
        String input = display.getUserInputOption();

        boolean isCheckoutBookSuccessfully = library.checkoutBook(input);
        if (isCheckoutBookSuccessfully) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public void menu() {
        showMenu();
        userInput = display.getUserInputOption();
        while (!userInput.equals("Q")) {

            switch (userInput) {
                case "1":
                    displayBooks();
                    break;
                case "2":
                    checkoutBook();
                    break;
                default:
                    displayInvalidMessage();
            }
            showMenu();
            userInput = display.getUserInputOption();
        }
    }
}
