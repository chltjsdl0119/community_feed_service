package seungwon.community_feed_service.acceptance.utils;

import org.springframework.stereotype.Component;
import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.application.dto.FollowUserRequestDto;

import static seungwon.community_feed_service.acceptance.steps.UserAcceptanceSteps.createUser;
import static seungwon.community_feed_service.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    public void loadData() {
        CreateUserRequestDto dto = new CreateUserRequestDto("test user", "");
        createUser(dto);
        createUser(dto);
        createUser(dto);

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }
}
