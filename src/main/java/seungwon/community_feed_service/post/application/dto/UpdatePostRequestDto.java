package seungwon.community_feed_service.post.application.dto;

import seungwon.community_feed_service.post.domain.PostPublicationState;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublicationState state) {
}
