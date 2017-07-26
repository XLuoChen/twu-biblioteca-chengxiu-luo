package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayTest {
    private Display display;
    private Library library;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        library = mock(Library.class);
    }

    @Test
    public void displayBooksWhenInputOne() throws Exception {
        Display d = new Display(display);
        when(d.getUserInputOption()).thenReturn(1);
        d.displayInformationWithUserInput();
        verify(display).displayBooks();
    }

//    @Test
//    public void displayInvalidMessageWhenInputValid() throws Exception {
//        when(display.getUserInputOption()).thenReturn(0);
//        display.displayInformationWithUserInput();
//        verify(display).displayInvalidMessage();
//    }
}