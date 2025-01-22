package seungwon.community_feed_service.post.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.comment.Comment;
import seungwon.community_feed_service.post.repository.entity.comment.CommentEntity;
import seungwon.community_feed_service.post.repository.entity.like.LikeEntity;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;
import seungwon.community_feed_service.post.repository.jpa.JpaCommentRepository;
import seungwon.community_feed_service.post.repository.jpa.JpaLikeRepository;
import seungwon.community_feed_service.post.repository.jpa.JpaPostRepository;
import seungwon.community_feed_service.user.domain.User;

@Repository
@RequiredArgsConstructor
public class LikeRepositoryImpl implements LikeRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final JpaPostRepository jpaPostRepository;
    private final JpaCommentRepository jpaCommentRepository;

    private final JpaLikeRepository jpaLikeRepository;

    @Override
    public boolean checkLike(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        return jpaLikeRepository.existsById(likeEntity.getId());
    }

    @Override
    @Transactional
    public void like(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        entityManager.persist(likeEntity);
        jpaPostRepository.updateLikeCount(new PostEntity(post));
    }

    @Override
    @Transactional
    public void unlike(Post post, User user) {
        LikeEntity likeEntity = new LikeEntity(post, user);
        jpaLikeRepository.deleteById(likeEntity.getId());
        jpaPostRepository.updateLikeCount(new PostEntity(post));
    }

    @Override
    public boolean checkLike(Comment comment, User user) {
        return false;
    }

    @Override
    public void like(Comment comment, User user) {

    }

    @Override
    public void unlike(Comment comment, User user) {

    }
}
