package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<Book>();

    public Library(){
        this.books.add(new Book("1","Book1","Jack","2002/4/12"));
        this.books.add(new Book("2","Book2","David","2012/2/14"));
        this.books.add(new Book("3","Book3","Tom","2013/9/12"));
    }

    public ArrayList<String> getBooks() {
        ArrayList<String> books = new ArrayList<String>();
        for (Book book : this.books) {
            books.add(book.getName());
        }

        return books;
    }

    private Book getBookById(String id) {
        for (int i = 0;i < this.books.size();i++) {

            if (this.books.get(i).getId().equals(id)){
                return this.books.get(i);
            }
        }
        return null;
    }

    public String getBookDetail(String id) {
        Book book = getBookById(id);
        if (book != null) {
            return book.getBookDetail();
        }
        return "Sorry, the book is not exist.";
    }

    public boolean checkoutBook(String id) {
        Book book = getBookById(id);
        if (book != null) {
                this.books.remove(book);
                return true;
            }

        return false;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void returnCheckoutBook(Book book) {
        this.books.add(book);
    }
}
