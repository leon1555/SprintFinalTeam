package com.keyin.team3.model.postgres;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PostGresMockDataTest {
    @Test
    void testConstructor() {
        PostGresMockData actualPostGresMockData = new PostGresMockData();
        assertNull(actualPostGresMockData.getAppnames());
        assertNull(actualPostGresMockData.getBuzzwords());
        assertNull(actualPostGresMockData.getCompanynames());
        assertEquals(0, actualPostGresMockData.getId());
        assertNull(actualPostGresMockData.getUseragent());
    }
}

