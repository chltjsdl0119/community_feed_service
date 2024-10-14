package com.seungwon.community_feed_service.user.application;

import com.seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import com.seungwon.community_feed_service.user.application.interfaces.UserRepository;
import com.seungwon.community_feed_service.user.domain.User;
import com.seungwon.community_feed_service.user.domain.UserInfo;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto) {
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }
}
