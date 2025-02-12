package seungwon.community_feed_service.post.repository.postqueue;

import seungwon.community_feed_service.post.repository.entity.post.PostEntity;

import java.util.List;

public interface UserQueueRedisRepository {

    void publishPostToToFollowingUserList(PostEntity postEntity, List<Long> userIdList);
    void publishPostListToFollowerList(List<PostEntity> postEntityList, Long userId);
    void deleteDeleteFeed(Long userId, Long authorId);
}
