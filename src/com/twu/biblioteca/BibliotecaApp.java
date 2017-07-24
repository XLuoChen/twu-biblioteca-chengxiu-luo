package com.twu.biblioteca;
import java.util.ArrayList;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();
    String[] meus = new String[1];

    BibliotecaApp() {
        for (int i = 0;i < 5;i++) {
            this.books.add(new Book(i, "《linux指南》", "David", "2003/3/12"));
        }
        this.meus[0] = "List Books";
    }

    String printWelcomeMessage(String message) {
        System.out.println(message);
        return message;
    }

    void listAllBooks () {
        for (Book book : (this.books)) {
            System.out.println(book.getName());
        }
    }

    void getBookDetail(int id) {
        Book book = this.books.get(id);
        System.out.println("名称：" + book.getName());
        System.out.println("作者：" + book.getAuthor());
        System.out.println("出版日期："+ book.getPublishedYear());
    }

    void showMenu() {
        for (String menu : this.meus)
        System.out.println(menu);
    }
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage("Welcome to BibliotecaApp");
        bibliotecaApp.showMenu();
    }
}
