package seungwon.community_feed_service.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
}
