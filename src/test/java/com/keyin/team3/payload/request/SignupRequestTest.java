package com.keyin.team3.payload.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

class SignupRequestTest {
    @Test
    void testConstructor() {
        SignupRequest actualSignupRequest = new SignupRequest();
        actualSignupRequest.setEmail("jane.doe@example.org");
        actualSignupRequest.setPassword("iloveyou");
        HashSet<String> stringSet = new HashSet<>();
        actualSignupRequest.setRole(stringSet);
        actualSignupRequest.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualSignupRequest.getEmail());
        assertEquals("iloveyou", actualSignupRequest.getPassword());
        assertSame(stringSet, actualSignupRequest.getRole());
        assertEquals("janedoe", actualSignupRequest.getUsername());
    }
}

