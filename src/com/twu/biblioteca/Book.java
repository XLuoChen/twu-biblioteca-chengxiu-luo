package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    String editor;

    Book (String name, String author, String editor) {
        this.setName(name);
        this.setAuthor(author);
        this.setEditor(editor);
    }

    void setName (String name) {
        this.name = name;
    }

    void setAuthor (String author) {
        this.author = author;
    }

    void setEditor (String editor) {
        this.editor = editor;
    }

    String getName () {
        return this.name;
    }

    String getAuthor () {
        return this.author;
    }

    String getEditor () {
        return this.editor;
    }
}
