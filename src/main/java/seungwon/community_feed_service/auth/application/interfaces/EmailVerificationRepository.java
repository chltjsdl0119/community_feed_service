package seungwon.community_feed_service.auth.application.interfaces;

import seungwon.community_feed_service.auth.domain.Email;

public interface EmailVerificationRepository {

    void createEmailVerification(Email email, String token);
}
