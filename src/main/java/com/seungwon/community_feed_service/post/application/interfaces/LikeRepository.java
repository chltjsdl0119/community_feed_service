package com.seungwon.community_feed_service.post.application.interfaces;

import com.seungwon.community_feed_service.post.Post;
import com.seungwon.community_feed_service.post.domain.comment.Comment;
import com.seungwon.community_feed_service.user.domain.User;

public interface LikeRepository {
    boolean checkLike(Post post, User user);
    void like(Post post, User user);
    void unlike(Post post, User user);

    boolean checkLike(Comment comment, User user);
    void like(Comment comment, User user);
    void unlike(Comment comment, User user);
}
