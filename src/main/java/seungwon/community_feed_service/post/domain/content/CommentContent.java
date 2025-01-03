package seungwon.community_feed_service.post.domain.content;

public class CommentContent extends Content {

    private static final int MAX_CONTENT_LENGTH = 100;

    public CommentContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException("contentText is null or empty");
        }

        if (contentText.length() > MAX_CONTENT_LENGTH) {
            throw new IllegalArgumentException("contentText is too long");
        }
    }
}