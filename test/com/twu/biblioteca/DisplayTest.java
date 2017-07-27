package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayTest {
    private Display display;
    private Display d;
    private Library library;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        library = mock(Library.class);
        d = new Display(display, library);
    }

    @Test
    public void displayBooksWhenInputOne() throws Exception {
        when(display.getUserInputOption()).thenReturn("1","Q");
        d.displayInformationWithUserInput();
        verify(display).displayBooks();
    }

    @Test
    public void displayInvalidMessageWhenInputValid() throws Exception {
        when(display.getUserInputOption()).thenReturn("k","Q");
        d.displayInformationWithUserInput();
        verify(display).displayInvalidMessage();
    }

    @Test
    public void shouldCheckoutBookWithInput() throws Exception {
        when(display.getUserInputOption()).thenReturn("2","Q");
        d.displayInformationWithUserInput();
        verify(display).checkoutBook();
    }
}