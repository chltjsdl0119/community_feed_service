package seungwon.community_feed_service.post.application;

import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import seungwon.community_feed_service.post.domain.Post;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostServiceTest extends PostApplicationTestTemplate {

    @Test
    void givenPostRequestDto_whenCreate_thenReturnPost() {
        // When
        Post savePost = postService.createPost(postRequestDto);

        // Then
        Post post = postService.getPost(savePost.getId());
        assertEquals(savePost, post);
    }

    @Test
    void givenCreatePost_whenUpdate_thenReturnUpdatedPost() {
        // Given
        Post savedPost = postService.createPost(postRequestDto);

        // When
        Post updatedPost = postService.updatePost(savedPost.getId(), postRequestDto);

        // Then
        assertEquals(savedPost.getId(), updatedPost.getId());
        assertEquals(savedPost.getAuthor(), updatedPost.getAuthor());
        assertEquals(savedPost.getContent(), updatedPost.getContent());
    }

    @Test
    void givenCreatedPost_whenLiked_thenReturnPostWithLike() {
        // Given
        Post savedPost = postService.createPost(postRequestDto);

        // When
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);

        // Then
        assertEquals(1, savedPost.getLikeCount());
    }

    @Test
    void givenCreatedPost_whenLikedTwice_thenReturnPostWithLike() {
        // Given
        Post savedPost = postService.createPost(postRequestDto);

        // When
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);
        postService.likePost(likeRequestDto);

        // Then
        assertEquals(1, savedPost.getLikeCount());
    }

    @Test
    void givenCreatedPostLike_whenUnliked_thenReturnPostWithoutLike() {
        // Given
        Post savedPost = postService.createPost(postRequestDto);
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);

        // When
        postService.unlikePost(likeRequestDto);

        // Then
        assertEquals(0, savedPost.getLikeCount());
    }

    @Test
    void givenCreatedPost_whenUnliked_thenReturnPostWithoutLike() {
        // Given
        Post savedPost = postService.createPost(postRequestDto);

        // When
        LikeRequestDto likeRequestDto = new LikeRequestDto(savedPost.getId(), otherUser.getId());
        postService.unlikePost(likeRequestDto);

        // Then
        assertEquals(0, savedPost.getLikeCount());
    }
}
