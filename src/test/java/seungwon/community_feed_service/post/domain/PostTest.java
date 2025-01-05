package seungwon.community_feed_service.post.domain;

import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.post.domain.content.PostContent;
import seungwon.community_feed_service.user.domain.User;
import seungwon.community_feed_service.user.domain.UserInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostTest {

    private final UserInfo info = new UserInfo("name", "url");
    private final User user = new User(1L, info);
    private final User otherUser = new User(2L, info);

    private final Post post = new Post(1L, user, new PostContent("content"));

    @Test
    void givenPostCreated_whenLike_thenLikeCountShouldBe1() {
        // When
        post.like(otherUser);

        // Then
        assertEquals(1, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenLikeByOtherUser_thenThrowException() {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> post.like(user));
    }

    @Test
    void givenPostCreatedAndLike_whenUnlike_thenLikeCountShouldBe0() {
        // Given
        post.like(otherUser);

        // When
        post.unLike();

        // Then
        assertEquals(0, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUnlike_thenLikeCountShouldBe0() {
        // When
        post.unLike();

        // Then
        assertEquals(0, post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUpdateContent_thenContentShouldBeUpdated() {
        // Given
        String newPostContent = "new content";

        // When
        post.updatePost(user, newPostContent, PostPublicationState.PUBLIC);

        // Then
        assertEquals(newPostContent, post.getContent());
    }

    @Test
    void givenCreated_whenUpdateOtherUserContent_thenThrowException() {
        // Given
        String newPostContent = "new content";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> post.updatePost(otherUser, newPostContent, PostPublicationState.PUBLIC));
    }
}
