package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @Test
    public void PrintWelcomeMessageTest() {
        assertEquals("Welcome to Biblioteca",bibliotecaApp.printWelcomeMessage("Welcome to Biblioteca"));
    }
}

