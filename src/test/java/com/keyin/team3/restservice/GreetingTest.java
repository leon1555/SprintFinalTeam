package com.keyin.team3.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreetingTest {
    @Test
    void testConstructor() {
        Greeting actualGreeting = new Greeting(123L, "Not all who wander are lost");

        assertEquals("Not all who wander are lost", actualGreeting.getContent());
        assertEquals(123L, actualGreeting.getId());
    }

    @Test
    void testConstructor2() {
        Greeting actualGreeting = new Greeting(123L, "Not all who wander are lost");

        assertEquals("Not all who wander are lost", actualGreeting.getContent());
        assertEquals(123L, actualGreeting.getId());
    }
}

