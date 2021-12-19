package com.keyin.team3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Team3ApplicationTest {
    @Test
    void testHello() {
        assertEquals("Hello Name!", (new Team3Application()).hello("Name"));
    }
}

