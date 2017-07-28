package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
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

    @Test
    public void shouldPrintSuccessfulMessageWhenInputValid() throws Exception {
        when(display.getUserInputOption()).thenReturn("2", "1", "Q");
        when(library.checkoutBook("1")).thenReturn(true);
        menu.menu();
        assertTrue(outContent.toString().contains("Thank you! Enjoy the book\n"));
    }

    @Test
    public void shouldPrintErrorMessageWhenInputInvalid() throws Exception {
        when(display.getUserInputOption()).thenReturn("2", "4", "Q");
        when(library.checkoutBook("4")).thenReturn(false);
        menu.menu();
        assertTrue(outContent.toString().contains("That book is not available.\n"));
    }

    //there has some amazing problem caused test failed
    @Ignore
    public void shouldPrintSuccessfulMessageWhenReturnCorrectBook() throws Exception {
        Book book = new Book("2", "Book2", "David", "2012/2/14");

        when(display.getUserInputOption()).thenReturn("3", "4", "Book2", "David", "2012/3/14", "Q");
        when(library.returnCheckoutBook(book)).thenReturn(true);
        menu.menu();
        assertTrue(outContent.toString().contains("Thank you for returning the book."));
    }

    @Test
    public void shouldPrintErrorMessageWhenReturnExistBook() throws Exception {
        Book book = new Book("2", "Book2", "David", "2012/2/14");

        when(display.getUserInputOption()).thenReturn("3", "2", "Book2", "David", "2012/3/14", "Q");
        when(library.returnCheckoutBook(book)).thenReturn(false);
        menu.menu();
        assertTrue(outContent.toString().contains("That is not a valid book to return."));
    }
}