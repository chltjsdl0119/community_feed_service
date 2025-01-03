package seungwon.community_feed_service.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
        // Given
        String name = "abcd";
        String profileImageUrl = "";

        // When
        // Then
        assertDoesNotThrow(() -> new UserInfo(name, profileImageUrl));
    }

    @Test
    void givenBlankNameAndProfileImage_whenCreated_thenThrowError() {
        // Given
        String name = "";
        String profileImageUrl = "";

        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> new UserInfo(name, profileImageUrl));
    }
}
