package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();

    public Library(){
        this.books.add(new Book("1","Book1","Jack","2002/4/12"));
        this.books.add(new Book("2","Book2","David","2012/2/14"));
        this.books.add(new Book("3","Book3","Tom","2013/9/12"));

        this.movies.add(new Movie("1", "Movie1", "2017/6/12", "zhangyimou", "2"));
        this.movies.add(new Movie("2", "Movie2", "2017/6/22", "Sam", "3"));
        this.movies.add(new Movie("3", "Movie3", "2017/7/25", "Roy", "unrated"));
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

    public boolean returnCheckoutBook(Book book) {
        if (getBookById(book.getId()) != null) {
            return false;
        }
        this.books.add(book);
        return true;
    }

    public ArrayList<Movie> getAvailableMovies() {
        return this.movies;
    }

    private Movie getMovieById(String id) {
        for (int i = 0;i < this.movies.size();i++) {

            if (this.movies.get(i).getId().equals(id)){
                return this.movies.get(i);
            }
        }
        return null;
    }

    public boolean checkoutMovie(String id) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            this.movies.remove(movie);
            return true;
        }

        return false;
    }
}
