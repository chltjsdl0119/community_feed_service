package com.seungwon.community_feed_service.post.application;

import com.seungwon.community_feed_service.post.Post;
import com.seungwon.community_feed_service.post.application.dto.CreatePostRequestDto;
import com.seungwon.community_feed_service.post.application.dto.LikePostRequestDto;
import com.seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import com.seungwon.community_feed_service.post.application.interfaces.PostRepository;
import com.seungwon.community_feed_service.user.application.UserService;
import com.seungwon.community_feed_service.user.domain.User;

public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;


    public PostService(UserService userService, PostRepository postRepository, LikeRepository likeRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
    }

    public Post getPost(Long id) {
        return postRepository.findBYId(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.userId());
        Post post = Post.createPost(null, author, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, CreatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updatePost(user, dto.content(), dto.state());

        return postRepository.save(post);
    }

    public void likePost(LikePostRequestDto dto) {
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(post, user)) {
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(LikePostRequestDto dto) {
        Post post = getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(post, user)) {
            post.unLike();
            likeRepository.unlike(post, user);
        }
    }
}
