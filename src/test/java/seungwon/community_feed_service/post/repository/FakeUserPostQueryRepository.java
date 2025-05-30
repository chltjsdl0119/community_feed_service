package seungwon.community_feed_service.post.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.post.repository.entity.post.PostEntity;
import seungwon.community_feed_service.post.repository.postqueue.UserPostQueueQueryRepository;
import seungwon.community_feed_service.post.ui.dto.GetPostContentResponseDto;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class FakeUserPostQueryRepository implements UserPostQueueQueryRepository {

    private final FakeUserQueueRedisRepository fakeUserQueueRedisRepository;

    public FakeUserPostQueryRepository(FakeUserQueueRedisRepository fakeUserQueueRedisRepository) {
        this.fakeUserQueueRedisRepository = fakeUserQueueRedisRepository;
    }

    @Override
    public List<GetPostContentResponseDto> getContentResponse(Long userId, Long lastPostId) {
        List<PostEntity> postEntities = fakeUserQueueRedisRepository.getPostsByUserId(userId);
        List<GetPostContentResponseDto> result = new ArrayList<>();

        for(PostEntity postEntity : postEntities) {
            GetPostContentResponseDto res = GetPostContentResponseDto.builder()
                    .id(postEntity.getId())
                    .build();

            result.add(res);
        }

        return result;
    }
}
