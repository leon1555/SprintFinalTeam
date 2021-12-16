package com.keyin.team3.model.mysql;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MySQLMockDataTest {
    @Test
    void testConstructor() {
        MySQLMockData actualMySQLMockData = new MySQLMockData();
        assertNull(actualMySQLMockData.getCarmake());
        assertNull(actualMySQLMockData.getCarmodel());
        assertNull(actualMySQLMockData.getColor());
        assertNull(actualMySQLMockData.getGender());
        assertNull(actualMySQLMockData.getId());
    }
}

