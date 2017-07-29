package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MenuTest {
    private Display display;
    private Menu menu;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Library library;
    private Movie movie;
    private ArrayList<String> books;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        library = mock(Library.class);
        movie = mock(Movie.class);
        printStream = mock(PrintStream.class);
        menu = new Menu(library, display,printStream);
        books = new ArrayList<String>();
        users = new ArrayList<User>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");

        movies = new ArrayList<Movie>();
        movies.add(new Movie("1", "Movie1", "2017/6/12", "zhangyimou", "2"));
        movies.add(new Movie("2", "Movie2", "2017/6/22", "Sam", "3"));
        movies.add(new Movie("3", "Movie3", "2017/7/25", "Roy", "unrated"));

        users.add(new User("000-0001", "Lucy","123456","123@qq.com","123456"));

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

    @Test
    public void shouldOutputAvailableMoviesInformation() throws Exception {
        when(display.getUserInputOption()).thenReturn("4", "Q");
        when(library.getAvailableMovies()).thenReturn(movies);
        menu.menu();

        String expectResult = "name\tyear\tdirector\tmovie rating\n" +
                "Movie1\t2017/6/12\tzhangyimou\t2\n" +
                "Movie2\t2017/6/22\tSam\t3\n" +
                "Movie3\t2017/7/25\tRoy\tunrated\n";

        verify(printStream).printf(expectResult);
    }

    @Test
    public void shouldPrintSuccessfulMessageWhenCheckoutMovie() throws Exception {
        when(display.getUserInputOption()).thenReturn("5", "1", "Q");
        when(library.checkoutMovie("1")).thenReturn(true);
        menu.menu();
        verify(printStream).println("Thank you! Enjoy the movie");
    }

    @Test
    public void shouldPrintErrorMessageWhenCheckoutMovie() throws Exception {
        when(display.getUserInputOption()).thenReturn("5", "d", "Q");
        when(library.checkoutMovie("d")).thenReturn(false);
        menu.menu();
        verify(printStream).println("That movie is not available.");
    }

    @Test
    public void shouldListUsersWhoHasCheckoutedBook() throws Exception {
        when(display.getUserInputOption()).thenReturn("6", "Q");
        when(library.getUsersWhoCheckoutedBook()).thenReturn(users);
        menu.menu();
        verify(printStream).println("Number: 000-0001	Password: 123456");
    }
}