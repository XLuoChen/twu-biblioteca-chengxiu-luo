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
        String booksList = "《linux指南》\n"
                + "《linux指南》\n"
                + "《linux指南》\n"
                + "《linux指南》\n"
                + "《linux指南》\n";
        bibliotecaApp.listAllBooks();
        assertEquals(booksList, outContent.toString());
    }

    @Test
    public void getBookDetailTest() {
        String bookDetail = "名称：《linux指南》\n" + "作者：David\n" + "出版日期：2003/3/12\n";
        bibliotecaApp.getBookDetail(1);
        assertEquals(bookDetail, outContent.toString());
    }
}

