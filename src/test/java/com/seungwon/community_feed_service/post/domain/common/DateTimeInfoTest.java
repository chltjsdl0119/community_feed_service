package com.seungwon.community_feed_service.post.domain.common;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeInfoTest {

    @Test
    void givenCreated_whenUpdated_thenTimeAndStateARsUpdated() {
        // Given
        DateTimeInfo dateTimeInfo = new DateTimeInfo();
        LocalDateTime localDateTime = dateTimeInfo.getDateTime();

        // When
        dateTimeInfo.updateEditDateTime();

        // Then
        assertTrue(dateTimeInfo.isEdited());
        assertNotEquals(localDateTime, dateTimeInfo.getDateTime());
    }
}
