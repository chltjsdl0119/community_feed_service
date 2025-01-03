package seungwon.community_feed_service.post.domain.comment;

import seungwon.community_feed_service.common.domain.PositiveIntegerCounter;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.content.Content;
import seungwon.community_feed_service.user.domain.User;

public class Comment {

    private final Long id;
    private final User author;
    private final Post post;
    private final Content content;
    private final PositiveIntegerCounter likeCounter;

    public Comment(Long id, User author, Post post, Content content) {
        if (author == null) {
            throw new IllegalArgumentException("author cannot be null");
        }

        if (post == null) {
            throw new IllegalArgumentException("post cannot be null");
        }

        if (content == null) {
            throw new IllegalArgumentException("content cannot be null");
        }

        this.id = id;
        this.author = author;
        this.post = post;
        this.content = content;
        this.likeCounter = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException("author cannot be the same user");
        }

        this.likeCounter.increase();
    }

    public void unLike(User user) {
        this.likeCounter.decrease();
    }

    public void updateComment(User user, String updateContent) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.content.updateContent(updateContent);
    }
}
