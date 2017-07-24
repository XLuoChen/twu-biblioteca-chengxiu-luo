package com.twu.biblioteca;

public class Book {
    int id;
    String name;
    String author;
    String publishedYear;

    Book (int id, String name, String author, String publishedYear) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setPublishedYear(publishedYear);
    }

    void setId(int id) {
        this.id = id;
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
