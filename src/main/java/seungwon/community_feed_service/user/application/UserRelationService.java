package seungwon.community_feed_service.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seungwon.community_feed_service.user.application.dto.FollowUserRequestDto;
import seungwon.community_feed_service.user.application.interfaces.UserRelationRepository;
import seungwon.community_feed_service.user.domain.User;

@Service
@RequiredArgsConstructor
public class UserRelationService {

    private final UserService userService;
    private final UserRelationRepository userRelationRepository;

    public void follow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (userRelationRepository.isAlreadyFollowed(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.follow(targetUser);
        userRelationRepository.save(user, targetUser);
    }

    public void unfollow(FollowUserRequestDto dto) {
        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if (!userRelationRepository.isAlreadyFollowed(user, targetUser)) {
            throw new IllegalArgumentException();
        }

        user.unfollow(targetUser);
        userRelationRepository.delete(user, targetUser);
    }
}
