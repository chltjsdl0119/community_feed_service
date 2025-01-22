package seungwon.community_feed_service.post.repository;

import seungwon.community_feed_service.post.application.interfaces.CommentRepository;
import seungwon.community_feed_service.post.domain.comment.Comment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeCommentRepository implements CommentRepository {

    private final Map<Long, Comment> store = new HashMap<>();

    @Override
    public Comment findById(Long id) {
        return store.get(id);
    }

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != null) {
            store.put(comment.getId(), comment);
            return comment;
        }

        long id = store.size() + 1;
        Comment newComment = new Comment(id, comment.getAuthor(), comment.getPost(), comment.getContentObject());
        store.put(id, newComment);
        return newComment;
    }
}
