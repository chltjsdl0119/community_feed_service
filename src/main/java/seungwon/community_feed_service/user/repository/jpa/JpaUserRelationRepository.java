package seungwon.community_feed_service.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import seungwon.community_feed_service.user.repository.entity.UserRelationEntity;
import seungwon.community_feed_service.user.repository.entity.UserRelationIdEntity;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {
}
