package com.seungwon.community_feed_service.post.application.interfaces;

import com.seungwon.community_feed_service.post.Post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findBYId(Long id);
}
