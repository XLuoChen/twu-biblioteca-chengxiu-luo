package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Menu {
    private Library library;
    private Display display;
    private String userInput;
    private PrintStream printStream;

    Menu(Library library, Display display, PrintStream printStream) {
        this.library = library;
        this.display = display;
        this.printStream = printStream;
    }

    public void showMenu() {
        System.out.println("\t-----------------------");
        System.out.println("\t\t1. List Books");
        System.out.println("\t\t2. Check out book");
        System.out.println("\t\t3. return book");
        System.out.println("\t\t4. List available movies");
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


    private void returnBook() {
        System.out.println("please input the book information that you want to return:");
        System.out.println("book number:");
        String id = display.getUserInputOption();
        System.out.println("book name:");
        String name = display.getUserInputOption();
        System.out.println("book author:");
        String author = display.getUserInputOption();
        System.out.println("book published year:");
        String publishedYear = display.getUserInputOption();

        Book book = new Book(id, name, author, publishedYear);
        boolean isReturnedSuccessfully = library.returnCheckoutBook(book);
        if (isReturnedSuccessfully) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private void listAvailableMovies() {
        ArrayList<Movie> movies = library.getAvailableMovies();
        String moviesInformation = "";

        for (Movie movie : movies) {
            moviesInformation += movie.getMovieDetail(movie);
        }

        printStream.printf("name\tyear\tdirector\tmovie rating\n" + moviesInformation);
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
                case "3":
                    returnBook();
                    break;
                case "4":
                    listAvailableMovies();
                    break;
                default:
                    displayInvalidMessage();
            }
            showMenu();
            userInput = display.getUserInputOption();
        }
    }
}
