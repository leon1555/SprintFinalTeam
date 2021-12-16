package com.keyin.team3.model.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RoleTest {
    @Test
    void testConstructor() {
        Role actualRole = new Role(ERole.ROLE_USER);
        assertNull(actualRole.getId());
        assertEquals(ERole.ROLE_USER, actualRole.getName());
    }
}

