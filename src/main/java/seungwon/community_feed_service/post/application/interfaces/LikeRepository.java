package seungwon.community_feed_service.post.application.interfaces;

import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.comment.Comment;
import seungwon.community_feed_service.user.domain.User;

public interface LikeRepository {

    // Post
    boolean checkLike(Post post, User user);
    void like(Post post, User user);
    void unlike(Post post, User user);

    // Comment
    boolean checkLike(Comment comment, User user);
    void like(Comment comment, User user);
    void unlike(Comment comment, User user);
}
