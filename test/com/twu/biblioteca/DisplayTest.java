package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayTest {
    private Display display;
    private Display d;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        d = new Display(display);
    }

    @Test
    public void displayBooksWhenInputOne() throws Exception {
        when(display.getUserInputOption()).thenReturn("1");
        d.displayInformationWithUserInput();
        verify(display).displayBooks();
    }

    @Test
    public void displayInvalidMessageWhenInputValid() throws Exception {
        when(display.getUserInputOption()).thenReturn("k");
        d.displayInformationWithUserInput();
        verify(display).displayInvalidMessage();
    }
}