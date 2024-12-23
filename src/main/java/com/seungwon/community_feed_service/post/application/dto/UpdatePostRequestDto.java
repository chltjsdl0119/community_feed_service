package com.seungwon.community_feed_service.post.application.dto;

import com.seungwon.community_feed_service.post.domain.content.PostPublicationState;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublicationState state) {
}
