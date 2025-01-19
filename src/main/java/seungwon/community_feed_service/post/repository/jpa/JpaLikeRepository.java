package seungwon.community_feed_service.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import seungwon.community_feed_service.post.repository.entity.like.LikeEntity;
import seungwon.community_feed_service.post.repository.entity.like.LikeIdEntity;

public interface JpaLikeRepository extends JpaRepository<LikeEntity, LikeIdEntity> {
}
