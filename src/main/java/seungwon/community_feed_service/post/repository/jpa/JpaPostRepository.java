package seungwon.community_feed_service.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

    @Modifying
    @Query(value = "UPDATE PostEntity p " +
            "SET p.content = :#{#postEntity.getContent()}, " +
            "p.state = :#{#postEntity.getState()}, " +
            "p.updDt = now()" +
            "WHERE p.id = :#{#postEntity.id}")
    void updatePostEntity(PostEntity postEntity);
}
