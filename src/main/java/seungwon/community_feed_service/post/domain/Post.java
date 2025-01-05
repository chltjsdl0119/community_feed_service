package seungwon.community_feed_service.post.domain;

import seungwon.community_feed_service.common.domain.PositiveIntegerCounter;
import seungwon.community_feed_service.post.domain.content.PostContent;
import seungwon.community_feed_service.user.domain.User;

public class Post {

    private Long id;
    private User author;
    private PostContent content;
    private final PositiveIntegerCounter likeCounter;
    private PostPublicationState state;

    public Post(Long id, User author, PostContent content) {
        if (author == null) {
            throw new IllegalArgumentException("authorId cannot be null");
        }

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCounter = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
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

    public int getLikeCount() {
        return likeCounter.getCount();
    }

    public String getContent() {
        return content.getContentText();
    }
}