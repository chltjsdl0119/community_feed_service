package seungwon.community_feed_service.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import seungwon.community_feed_service.post.repository.entity.comment.CommentEntity;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long> {

    @Modifying
    @Query(value = "UPDATE CommentEntity c " +
            "SET c.content = :#{#commentEntity.getContent()}," +
            "c.updDt = now()" +
            "WHERE c.id = :#{#commentEntity.getId()} ")
    void updateCommentEntity(CommentEntity commentEntity);

    @Modifying
    @Query(value = "UPDATE CommentEntity c " +
            "SET c.likeCount = c.likeCount + :likeCount," +
            "c.updDt = now()" +
            "WHERE c.id = :commentId")
    void updateLikeCount(Long commentId, Integer likeCount);
}
