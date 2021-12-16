package com.keyin.team3.security.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class JwtUtilsTest {
    @Test
    void testValidateJwtToken() {
        assertFalse((new JwtUtils()).validateJwtToken("ABC123"));
    }
}

