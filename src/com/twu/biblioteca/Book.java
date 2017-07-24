package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    String publishedYear;

    Book (String name, String author, String publishedYear) {
        this.setName(name);
        this.setAuthor(author);
        this.setPublishedYear(publishedYear);
    }

    void setName (String name) {
        this.name = name;
    }

    void setAuthor (String author) {
        this.author = author;
    }

    void setPublishedYear(String year) {
        this.publishedYear = year;
    }

    String getName () {
        return this.name;
    }

    String getAuthor () {
        return this.author;
    }

    String getPublishedYear() {
        return this.publishedYear;
    }
}
