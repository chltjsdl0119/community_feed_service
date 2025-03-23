package seungwon.community_feed_service.auth.application.dto;

public record CreateUserAuthRequestDto(String email, String password, String role, String name, String profileImageUrl) {
}
