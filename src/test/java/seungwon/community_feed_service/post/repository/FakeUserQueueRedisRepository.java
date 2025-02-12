package seungwon.community_feed_service.post.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;
import seungwon.community_feed_service.post.repository.postqueue.UserQueueRedisRepository;

import java.util.*;

@Repository
@Profile("test")
public class FakeUserQueueRedisRepository implements UserQueueRedisRepository {

    private final Map<Long, Set<PostEntity>> queue = new HashMap<>();

    @Override
    public void publishPostToToFollowingUserList(PostEntity postEntity, List<Long> userIdList) {
        for (Long userId: userIdList) {
            if (queue.containsKey(userId)) {
                queue.get(userId).add(postEntity);
            } else {
                queue.put(userId, new HashSet<>(List.of(postEntity)));
            }
        }
    }

    @Override
    public void publishPostListToFollowerList(List<PostEntity> postEntities, Long userId) {
        if (queue.containsKey(userId)){
            queue.get(userId).addAll(postEntities);
        } else {
            queue.put(userId, new HashSet<>(postEntities));
        }
    }

    @Override
    public void deleteDeleteFeed(Long userId, Long targetUserId) {
        if (queue.containsKey(userId)) {
            queue.get(userId).removeIf(post -> post.getAuthor().getId().equals(targetUserId));
        }
    }
    public List<PostEntity> getPostsByUserId(Long userId) {
        return List.copyOf(queue.get(userId));
    }
}
