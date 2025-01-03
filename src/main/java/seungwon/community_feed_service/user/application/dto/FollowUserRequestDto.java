package seungwon.community_feed_service.user.application.dto;

public record FollowUserRequestDto(Long userId, Long targetUserId) {
}
