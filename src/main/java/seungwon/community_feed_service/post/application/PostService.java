package seungwon.community_feed_service.post.application;

import org.springframework.stereotype.Service;
import seungwon.community_feed_service.post.application.dto.CreatePostRequestDto;
import seungwon.community_feed_service.post.application.dto.LikeRequestDto;
import seungwon.community_feed_service.post.application.dto.UpdatePostRequestDto;
import seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import seungwon.community_feed_service.post.application.interfaces.PostRepository;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.user.application.UserService;
import seungwon.community_feed_service.user.domain.User;

@Service
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
        return postRepository.findById(id);
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.userId());
        Post post = Post.createPost(null, author, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, UpdatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updatePost(user, dto.content(), dto.state());

        return postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(post, user)) {
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(LikeRequestDto dto) {
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if (likeRepository.checkLike(post, user)) {
            post.unLike();
            likeRepository.unlike(post, user);
        }
    }
}
