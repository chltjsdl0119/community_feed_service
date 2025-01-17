package seungwon.community_feed_service.post.application.interfaces;

import seungwon.community_feed_service.post.domain.Post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);
    Post findById(Long id);
}
