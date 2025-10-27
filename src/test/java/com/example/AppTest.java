package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for App class
 */
public class AppTest {

    @Test
    public void testGetGreeting() {
        App app = new App();
        String greeting = app.getGreeting();
        assertNotNull("Greeting should not be null", greeting);
        assertEquals("Hello from Java CI/CD Demo!", greeting);
    }

    @Test
    public void testAppNotNull() {
        App app = new App();
        assertNotNull("App instance should not be null", app);
    }
}
