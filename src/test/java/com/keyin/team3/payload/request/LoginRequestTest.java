package com.keyin.team3.payload.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LoginRequestTest {
    @Test
    void testConstructor() {
        LoginRequest actualLoginRequest = new LoginRequest();
        actualLoginRequest.setPassword("iloveyou");
        actualLoginRequest.setUsername("janedoe");
        assertEquals("iloveyou", actualLoginRequest.getPassword());
        assertEquals("janedoe", actualLoginRequest.getUsername());
    }
}

