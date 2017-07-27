package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<Book>();

   public Library() {
       readBooksFromMemory();
    }

    private void readBooksFromMemory(){
        this.books.add(new Book(0,"Book1","Jack","2002/4/12"));
        this.books.add(new Book(1,"Book2","David","2012/2/14"));
        this.books.add(new Book(2,"Book3","Tom","2013/9/12"));
    }

    public ArrayList<String> getBooks() {
        ArrayList<String> books = new ArrayList<String>();
        for (Book book : this.books) {
            books.add(book.getName());
        }

        return books;
    }

    public String getBookDetail(int id) {
        Book book = this.books.get(id);
        if (book != null) {
            return book.getBookDetail();
        }
        return "Sorry, the book is not exist.";
    }

    public boolean checkoutBook(int id) {
        if (id < this.books.size()) {
            Book book = this.books.get(id);
            if (book != null) {
                this.books.remove(id);
                return true;
            }
        }
        return false;
    }
}
