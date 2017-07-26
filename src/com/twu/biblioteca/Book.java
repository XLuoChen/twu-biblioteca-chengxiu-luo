package com.twu.biblioteca;

import static java.lang.String.format;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publishedYear;

    Book (int id, String name, String author, String publishedYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String getBookDetail() {
        return format("name: %-4s author:%-4s publishedYear:%-4s",this.name, this.author, this.publishedYear);
    }
}
