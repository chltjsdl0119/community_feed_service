package seungwon.community_feed_service.user.application;

import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.application.interfaces.UserRepository;
import seungwon.community_feed_service.user.domain.User;
import seungwon.community_feed_service.user.domain.UserInfo;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto) {
        UserInfo userInfo = new UserInfo(dto.userName(), dto.userProfileUrl());
        User user = new User(null, userInfo);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
