package seungwon.community_feed_service.post.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.post.application.interfaces.CommentRepository;
import seungwon.community_feed_service.post.domain.comment.Comment;
import seungwon.community_feed_service.post.repository.entity.comment.CommentEntity;
import seungwon.community_feed_service.post.repository.jpa.JpaCommentRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = new CommentEntity(comment);
        if (comment.getId() != null) {
            jpaCommentRepository.updateCommentEntity(commentEntity);
            return comment;
        }

        commentEntity = jpaCommentRepository.save(commentEntity);
        return commentEntity.toComment();
    }

    @Override
    public Comment findById(Long id) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElseThrow();
        return commentEntity.toComment();
    }
}
