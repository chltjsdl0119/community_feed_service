package seungwon.community_feed_service.post.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seungwon.community_feed_service.common.ui.Response;
import seungwon.community_feed_service.post.application.CommentService;
import seungwon.community_feed_service.post.application.dto.CreateCommentRequestDto;
import seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import seungwon.community_feed_service.post.application.dto.UpdateCommentRequestDto;
import seungwon.community_feed_service.post.domain.comment.Comment;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Response<Long> createComment(@RequestBody CreateCommentRequestDto dto) {
        Comment comment = commentService.createComment(dto);
        return Response.ok(comment.getId());
    }

    @PatchMapping("/{commentId}")
    public Response<Long> updateComment(@PathVariable(name = "commentId")Long commentId, @RequestBody UpdateCommentRequestDto dto) {
        Comment comment = commentService.updateComment(commentId, dto);
        return Response.ok(comment.getId());
    }
}
