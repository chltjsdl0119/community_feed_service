package seungwon.community_feed_service.post.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seungwon.community_feed_service.common.ui.Response;
import seungwon.community_feed_service.post.application.PostService;
import seungwon.community_feed_service.post.application.dto.CreatePostRequestDto;
import seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import seungwon.community_feed_service.post.application.dto.UpdatePostRequestDto;
import seungwon.community_feed_service.post.domain.Post;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Long> createPost(@RequestBody CreatePostRequestDto dto) {
        Post post = postService.createPost(dto);
        return Response.ok(post.getId());
    }

    @PatchMapping("/{postId}")
    public Response<Long> updatePost(@PathVariable(name = "postId")Long postId, @RequestBody UpdatePostRequestDto dto) {
        Post post = postService.updatePost(postId, dto);
        return Response.ok(post.getId());
    }

    @PostMapping("/like")
    public Response<Void> likePost(@RequestBody LikeRequestDto dto) {
        postService.likePost(dto);
        return Response.ok(null);
    }

    @PostMapping("/unlike")
    public Response<Void> unlikePost(@RequestBody LikeRequestDto dto) {
        postService.unlikePost(dto);
        return Response.ok(null);
    }
}
