package com.seungwon.community_feed_service.post.application;

import com.seungwon.community_feed_service.post.Post;
import com.seungwon.community_feed_service.post.application.dto.CreateCommentRequestDto;
import com.seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import com.seungwon.community_feed_service.post.application.dto.UpdateCommentRequestDto;
import com.seungwon.community_feed_service.post.application.interfaces.CommentRepository;
import com.seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import com.seungwon.community_feed_service.post.domain.comment.Comment;
import com.seungwon.community_feed_service.user.application.UserService;
import com.seungwon.community_feed_service.user.domain.User;

public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    private final LikeRepository likeRepository;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService, LikeRepository likeRepository) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
        this.likeRepository = likeRepository;
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Comment createComment(CreateCommentRequestDto dto) {
        Post post = postService.getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        Comment comment = Comment.createComment(user, post, dto.content());
        return commentRepository.save(comment);
    }

    public Comment updateComment(UpdateCommentRequestDto dto) {
        Comment comment = getComment(dto.commentId());
        User user = userService.getUser(dto.userId());

        comment.updateComment(user, dto.content());
        return commentRepository.save(comment);
    }

    public void likeComment(LikeRequestDto dto) {
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(comment, user)) {
            return;
        }

        comment.like(user);
        likeRepository.like(comment, user);
    }

    public void unlikeComment(LikeRequestDto dto) {
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(comment, user)) {
            comment.unLike();
            likeRepository.unlike(comment, user);
        }
    }
}
