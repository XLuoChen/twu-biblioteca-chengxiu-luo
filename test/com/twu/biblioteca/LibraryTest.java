package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private Library library;
    private Book book;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        book = mock(Book.class);
    }

    @Test
    public void shouldGetAllBooks() throws Exception {
        ArrayList<String> books =new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        assertEquals(books, library.getBooks());
    }


    @Test
    public void shouldGetBookDetailByBookId() throws Exception {
        when(book.getBookDetail()).thenReturn("name: Book2 author:David publishedYear:2012/2/14");
        assertEquals("name: Book2 author:David publishedYear:2012/2/14", library.getBookDetail("2"));
    }

    @Test
    public void shouldCheckoutBookAndReturnTrueWithCorrectId() throws Exception {
        ArrayList<String> books =new ArrayList<String>();
        books.add("Book1");
        books.add("Book3");
        assertEquals(true, library.checkoutBook("2"));
        assertEquals(books, library.getBooks());
    }

    @Test
    public void shouldOutputInvalidWhenCheckoutInvalidBook() throws Exception {
        ArrayList<String> books =new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        assertEquals(false, library.checkoutBook("5"));
        assertEquals(books, library.getBooks());
    }

    @Test
    public void shouldAddBookWhenCheckoutBook() throws Exception {
        ArrayList<Book> books =new ArrayList<Book>();
        books.add(new Book("1","Book1","Jack","2002/4/12"));
        books.add(new Book("3","Book3","Tom","2013/9/12"));

        library.setBooks(books);
        Book book = new Book("2", "Book2", "David", "2012/2/14");
        library.returnCheckoutBook(book);
        assertEquals(books.size(), library.getBooks().size());
    }
}