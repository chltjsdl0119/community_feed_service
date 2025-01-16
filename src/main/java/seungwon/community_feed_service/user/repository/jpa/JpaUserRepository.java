package seungwon.community_feed_service.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import seungwon.community_feed_service.user.repository.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
