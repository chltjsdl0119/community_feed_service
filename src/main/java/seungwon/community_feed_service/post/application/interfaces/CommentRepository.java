package seungwon.community_feed_service.post.application.interfaces;

import seungwon.community_feed_service.post.domain.comment.Comment;

import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);
    Comment findById(Long id);
}
