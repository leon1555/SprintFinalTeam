package com.keyin.team3.model.mysql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class HistoryTest {
    @Test
    void testConstructor() {
        History actualHistory = new History();
        actualHistory.setDb("Db");
        actualHistory.setId(123L);
        actualHistory.setQueryDateTime(mock(Timestamp.class));
        actualHistory.setSearchQuery("Search Query");
        actualHistory.setUserId(123);
        assertEquals("Db", actualHistory.getDb());
        assertEquals(123L, actualHistory.getId());
        assertEquals("Search Query", actualHistory.getSearchQuery());
        assertEquals(123, actualHistory.getUserId().intValue());
    }
}

