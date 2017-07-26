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
    public void getBooksTest() throws Exception {
        ArrayList<String> books =new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        assertEquals(books, library.getBooks());
    }


    @Test
    public void getBookDetailTest() throws Exception {
        when(book.getBookDetail()).thenReturn("name: Book2 author:David publishedYear:2012/2/14");
        assertEquals("name: Book2 author:David publishedYear:2012/2/14", library.getBookDetail(1));
    }
}