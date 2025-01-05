package seungwon.community_feed_service.post.application.dto;

public record UpdateCommentRequestDto(Long commentId, Long userId, String content) {
}
