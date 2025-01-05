package seungwon.community_feed_service.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.fake.FakeObjectFactory;
import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.application.dto.FollowUserRequestDto;
import seungwon.community_feed_service.user.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRelationServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();
    private final UserRelationService userRelationService = FakeObjectFactory.getUserRelationService();

    private User user1;
    private User user2;

    private FollowUserRequestDto requestDto;

    @BeforeEach
    void init() {
        CreateUserRequestDto dto = new CreateUserRequestDto("test", "");
        user1 = userService.createUser(dto);
        user2 = userService.createUser(dto);

        this.requestDto = new FollowUserRequestDto(user1.getId(), user2.getId());
    }

    @Test
    void givenCreateTwoUser_whenFollow_thenUserFollowSaved() {
        // When
        userRelationService.follow(requestDto);

        // Then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(1, user2.getFollowerCount());
    }

    @Test
    void givenCreateTwoUserFollowed_whenFollow_thenUserThrowError() {
        // Given
        userRelationService.follow(requestDto);

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(requestDto));
    }

    @Test
    void givenCreateOneUserFollowed_whenFollow_thenUserThrowError() {
        // Given
        FollowUserRequestDto dto = new FollowUserRequestDto(user1.getId(), user1.getId());

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.follow(dto));
    }

    @Test
    void givenCreateTwoUserFollowed_whenUnfollow_thenUserUnfollowSaved() {
        // Given
        userRelationService.follow(requestDto);

        // When
        userRelationService.unfollow(requestDto);

        // Then
        assertEquals(0, user1.getFollowingCount());
        assertEquals(0, user2.getFollowerCount());
    }

    @Test
    void givenCreateTwoUser_whenFollow_thenUserThrowError() {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(requestDto));
    }

    @Test
    void givenCreateOneUser_whenUnfollowSelf_thenUserThrowError() {
        FollowUserRequestDto sameUser = new FollowUserRequestDto(user1.getId(), user1.getId());

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(sameUser));
    }
}