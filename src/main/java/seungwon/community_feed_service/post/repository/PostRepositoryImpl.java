package seungwon.community_feed_service.post.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import seungwon.community_feed_service.post.application.interfaces.PostRepository;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;
import seungwon.community_feed_service.post.repository.jpa.JpaPostRepository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    @Transactional
    public Post save(Post post) {
        PostEntity postEntity = new PostEntity(post);

        if (post.getId() != null) {
            jpaPostRepository.updatePostEntity(postEntity);
            return postEntity.toPost();
        }

        postEntity = jpaPostRepository.save(postEntity);
        return postEntity.toPost();
    }

    @Override
    public Post findById(Long id) {
        PostEntity post = jpaPostRepository.findById(id).orElseThrow();
        return post.toPost();
    }
}
