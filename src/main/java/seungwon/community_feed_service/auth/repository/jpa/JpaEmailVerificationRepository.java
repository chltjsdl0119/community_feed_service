package seungwon.community_feed_service.auth.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import seungwon.community_feed_service.auth.repository.entity.EmailVerificationEntity;

import java.util.Optional;

public interface JpaEmailVerificationRepository extends JpaRepository<EmailVerificationEntity, Long> {

    Optional<EmailVerificationEntity> findByEmail(String email);
}
