package seungwon.community_feed_service.post.application;

import org.junit.jupiter.api.Test;
import seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import seungwon.community_feed_service.post.application.dto.UpdateCommentRequestDto;
import seungwon.community_feed_service.post.domain.comment.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentServiceTest extends PostApplicationTestTemplate{

    @Test
    void givenCreateCommentRequestDto_whenCreateComment_thenReturnComment() {
        // When
        Comment comment = commentService.createComment(commentRequestDto);

        // Then
        String content = comment.getContent();
        assertEquals(commentContentText, content);
    }

    @Test
    void givenCreateComment_whenUpdateComment_thenReturnUpdatedComment() {
        // Given
        Comment comment = commentService.createComment(commentRequestDto);

        // When
        UpdateCommentRequestDto updateCommentRequestDto = new UpdateCommentRequestDto(user.getId(), "updated content");
        Comment updatedComment = commentService.updateComment(comment.getId(), updateCommentRequestDto);

        // Then
        assertEquals(comment.getId(), updatedComment.getId());
        assertEquals(comment.getAuthor(), updatedComment.getAuthor());
        assertEquals(comment.getContent(), updatedComment.getContent());
    }

    @Test
    void givenComment_whenLikeComment_thenReturnCommentWithLike() {
        // Given
        Comment comment = commentService.createComment(commentRequestDto);

        // When
        LikeRequestDto likeRequestDto = new LikeRequestDto(comment.getId(), otherUser.getId());
        commentService.likeComment(likeRequestDto);

        // Then
        assertEquals(1, comment.getLikeCount());
    }

    @Test
    void givenComment_whenUnlikeComment_thenReturnCommentWithoutLike() {
        // Given
        Comment comment = commentService.createComment(commentRequestDto);

        // When
        LikeRequestDto likeRequestDto = new LikeRequestDto(comment.getId(), otherUser.getId());
        commentService.likeComment(likeRequestDto);
        commentService.unlikeComment(likeRequestDto);

        // Then
        assertEquals(0, comment.getLikeCount());
    }
}
