package seungwon.community_feed_service.post.repository.postqueue;

import seungwon.community_feed_service.post.ui.dto.GetPostContentResponseDto;

import java.util.List;

public interface UserPostQueueQueryRepository {

    List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastPostId);
}
