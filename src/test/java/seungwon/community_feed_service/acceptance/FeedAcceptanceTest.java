package seungwon.community_feed_service.acceptance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.acceptance.utils.AcceptanceTestTemplate;
import seungwon.community_feed_service.post.application.dto.CreatePostRequestDto;
import seungwon.community_feed_service.post.domain.PostPublicationState;
import seungwon.community_feed_service.post.ui.dto.GetPostContentResponseDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seungwon.community_feed_service.acceptance.steps.FeedAcceptanceSteps.requestCreatePost;
import static seungwon.community_feed_service.acceptance.steps.FeedAcceptanceSteps.requestFeed;

class FeedAcceptanceTest extends AcceptanceTestTemplate {

    /**
     * User 1 --- follow ---> User 2
     * User 1 --- follow ---> User 3
     */
    @BeforeEach
    void setUp () {
        super.init();
    }

    /**
     * User 2 create Post 1
     * user 1 Get Post 1 From Feed
     */
    @Test
    void givenUserHasFollowerAndCreatePost_whenFollowerUserRequestFeed_thenFollowerCanGetPostFromFeed() {
        // Given
        CreatePostRequestDto dto = new CreatePostRequestDto(2L, "user 1 can get this post", PostPublicationState.PUBLIC);
        Long createPostId = requestCreatePost(dto);

        // When, 팔로워 피드를 요청
        List<GetPostContentResponseDto> result = requestFeed(1L);

        // Then
        assertEquals(1, result.size());
        assertEquals(createPostId, result.get(0).getId());
    }
}
