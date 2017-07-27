package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Display display;
    private Menu menu;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Library library;
    private ArrayList<String> books;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        library = mock(Library.class);
        menu = new Menu(library, display);
        books = new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void displayBooksWhenInputOne() throws Exception {
        when(display.getUserInputOption()).thenReturn("1", "Q");
        when(library.getBooks()).thenReturn(books);
        menu.menu();
        assertTrue(outContent.toString().contains("Book1\nBook2\nBook3\n"));
    }
}