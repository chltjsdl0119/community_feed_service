package com.seungwon.community_feed_service.post;

import com.seungwon.community_feed_service.common.domain.PositiveIntegerCounter;
import com.seungwon.community_feed_service.post.domain.content.Content;
import com.seungwon.community_feed_service.post.domain.content.PostContent;
import com.seungwon.community_feed_service.post.domain.content.PostPublicationState;
import com.seungwon.community_feed_service.user.domain.User;

public class Post {

    private Long id;
    private User author;
    private Content content;
    private final PositiveIntegerCounter likeCounter;
    private PostPublicationState state;

    public static Post createPost(Long id, User author, String content, PostPublicationState state) {
        return new Post(id, author, new PostContent(content), state);
    }

    public static Post createDefaultStatePost(Long id, User author, String content) {
        return new Post(id, author, new PostContent(content), PostPublicationState.PUBLIC);

    }

    public Post(Long id, User author, Content content) {
        this(id, author, content, PostPublicationState.PUBLIC);
    }

    public Post(Long id, User author, Content content, PostPublicationState state) {
        if (author == null) {
            throw new IllegalArgumentException("authorId cannot be null");
        }

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCounter = new PositiveIntegerCounter();
        this.state = state;
    }

    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException("author cannot be the same user");
        }

        this.likeCounter.increase();
    }

    public void unLike() {
        this.likeCounter.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.state = state;
        this.content.updateContent(updateContent);
    }

    public int getLikeCounter() {
        return likeCounter.getCount();
    }

    public String getContent() {
        return content.getContentText();
    }
}
