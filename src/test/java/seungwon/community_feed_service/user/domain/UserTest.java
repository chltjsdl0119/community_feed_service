package seungwon.community_feed_service.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final UserInfo userInfo = new UserInfo("test", "");
    private User user1;
    private User user2;

    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenTwoUser_whenEqual_thenReturnFalse() {
        // When
        boolean isSame = user1.equals(user2);

        // Then
        assertFalse(isSame);
    }

    @Test
    void givenSameUser_whenEqual_thenReturnTrue() {
        // Given
        User sameUser = new User(1L, userInfo);

        // When
        boolean isSame = user1.equals(sameUser);

        // Then
        assertTrue(isSame);
    }

    @Test
    void givenTwoUser_whenHashCode_thenNotEqual() {
        // When
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();

        // Then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void givenTwoUser_whenHashCode_thenEqual() {
        // Given
        User sameUser = new User(1L, userInfo);

        // When
        int hashCode1 = user1.hashCode();
        int sameUserHashCode = sameUser.hashCode();

        // Then
        assertEquals(hashCode1, sameUserHashCode);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
        // When
        user1.follow(user2);

        // Then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(1, user2.getFollowerCount());
    }

    @Test
    void givenTwoUserUser1FollowUser2_whenUnFollow_thenDecreaseUserCount() {
        // Given
        user1.follow(user2);

        // When
        user1.unfollow(user2);

        // Then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }

    @Test
    void givenTwoUser_whenUnFollow_thenNotDecreaseUserCount() {
        // When
        user1.unfollow(user2);

        // Then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }
}
