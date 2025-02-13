package seungwon.community_feed_service.auth.application.interfaces;

import seungwon.community_feed_service.auth.domain.Email;

public interface EmailSendRepository {

    void sendEmail(Email email, String randomToken);
}
