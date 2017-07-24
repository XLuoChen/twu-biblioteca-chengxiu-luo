package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void PrintWelcomeMessageTest() {
        assertEquals("Welcome to Biblioteca",bibliotecaApp.printWelcomeMessage("Welcome to Biblioteca"));
    }

    @Test
    public void listAllBooksTest() {
        String booksList = "《linux指南》\tDavid\t人民邮电出版社\n"
                + "《linux指南》\tDavid\t人民邮电出版社\n"
                + "《linux指南》\tDavid\t人民邮电出版社\n"
                + "《linux指南》\tDavid\t人民邮电出版社\n"
                + "《linux指南》\tDavid\t人民邮电出版社\n";
        bibliotecaApp.listAllBooks();
        assertEquals(booksList, outContent.toString());
    }
}

