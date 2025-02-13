package seungwon.community_feed_service.auth.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.auth.application.interfaces.EmailVerificationRepository;
import seungwon.community_feed_service.auth.domain.Email;
import seungwon.community_feed_service.auth.repository.entity.EmailVerificationEntity;
import seungwon.community_feed_service.auth.repository.jpa.JpaEmailVerificationRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmailVerificationRepositoryImpl implements EmailVerificationRepository {

    private final JpaEmailVerificationRepository jpaEmailVerificationRepository;

    @Override
    public void createEmailVerification(Email email, String token) {
        String emailAddress = email.getEmailText();
        Optional<EmailVerificationEntity> entity = jpaEmailVerificationRepository.findByEmail(emailAddress);

        if (entity.isPresent()) {
            EmailVerificationEntity emailVerificationEntity = entity.get();

            if(emailVerificationEntity.isVerified()) {
                throw new IllegalArgumentException("이미 인증된 이메일입니다.");
            }

            emailVerificationEntity.updateToken(token);
        }

        EmailVerificationEntity emailVerificationEntity = new EmailVerificationEntity(emailAddress, token);

    }
}
