package seungwon.community_feed_service.post.repository.postqueue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;
import seungwon.community_feed_service.post.repository.jpa.JpaPostRepository;
import seungwon.community_feed_service.user.repository.entity.UserEntity;
import seungwon.community_feed_service.user.repository.jpa.JpaUserRelationRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final UserQueueRedisRepository redisRepository;

    @Override
    @Transactional
    public void publishPost(PostEntity postEntity) {
        UserEntity userEntity = postEntity.getAuthor();
        List<Long> followersIds = jpaUserRelationRepository.findFollowers(userEntity.getId());
        redisRepository.publishPostToToFollowingUserList(postEntity, followersIds);
    }

    @Override
    @Transactional
    public void saveFollowPost(Long userId, Long targetId) {
        List<PostEntity> postEntities = jpaPostRepository.findAllPostIdsByAuthorId(targetId);
        redisRepository.publishPostListToFollowerList(postEntities, userId);
    }

    @Override
    @Transactional
    public void deleteUnfollowPost(Long userId, Long targetId) {
        redisRepository.deleteDeleteFeed(userId, targetId);
    }
}
