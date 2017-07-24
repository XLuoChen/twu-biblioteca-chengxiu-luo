package com.twu.biblioteca;

public class BibliotecaApp {
    Book[] books = new Book[5];

    BibliotecaApp() {
        for (int i = 0;i < this.books.length;i++) {
            this.books[i] = new Book("《linux指南》", "David", "2003/3/12");
        }
    }

    String printWelcomeMessage(String message) {
        System.out.println(message);
        return message;
    }

    void listAllBooks () {
        for (Book book : (this.books)) {
            System.out.println(book.name);
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage("Welcome to BibliotecaApp");
        bibliotecaApp.listAllBooks();
    }
}
