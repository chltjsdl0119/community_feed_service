package seungwon.community_feed_service.post.application.dto;

import seungwon.community_feed_service.post.domain.PostPublicationState;

public record CreatePostRequestDto(Long userId, String content, PostPublicationState state) {
}
