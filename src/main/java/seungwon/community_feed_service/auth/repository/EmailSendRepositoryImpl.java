package seungwon.community_feed_service.auth.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.auth.application.interfaces.EmailSendRepository;
import seungwon.community_feed_service.auth.domain.Email;

@Repository
@RequiredArgsConstructor
public class EmailSendRepositoryImpl implements EmailSendRepository {


    @Override
    public void sendEmail(Email email, String token) {

    }
}
