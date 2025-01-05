package seungwon.community_feed_service.post.application.dto;

public record CreateCommentRequestDto(Long postId, Long userId, String content) {
}
