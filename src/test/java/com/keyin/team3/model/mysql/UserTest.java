package com.keyin.team3.model.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testConstructor() {
        User actualUser = new User("janedoe", "jane.doe@example.org", "iloveyou");

        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("janedoe", actualUser.getUsername());
        assertTrue(actualUser.getRoles().isEmpty());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals(0L, actualUser.getId());
    }
}

