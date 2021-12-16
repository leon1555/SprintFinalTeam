package com.keyin.team3.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class mockDataControllerTest {
    @Test
    void testGreeting() {
        Greeting actualGreetingResult = (new mock_data_controller()).greeting("Name");
        assertEquals("Hello, Name!", actualGreetingResult.getContent());
        assertEquals(1L, actualGreetingResult.getId());
    }
}

