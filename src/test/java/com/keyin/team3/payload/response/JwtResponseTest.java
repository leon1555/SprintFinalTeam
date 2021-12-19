package com.keyin.team3.payload.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JwtResponseTest {
    @Test
    void testConstructor() {
        ArrayList<String> stringList = new ArrayList<>();
        JwtResponse actualJwtResponse = new JwtResponse("ABC123", 123L, "janedoe", "jane.doe@example.org", stringList);

        assertEquals("jane.doe@example.org", actualJwtResponse.getEmail());
        assertEquals("janedoe", actualJwtResponse.getUsername());
        assertEquals("Bearer", actualJwtResponse.getType());
        assertEquals("ABC123", actualJwtResponse.getToken());
        List<String> roles = actualJwtResponse.getRoles();
        assertSame(stringList, roles);
        assertTrue(roles.isEmpty());
        assertEquals(123L, actualJwtResponse.getId().longValue());
        assertSame(roles, stringList);
    }
}

