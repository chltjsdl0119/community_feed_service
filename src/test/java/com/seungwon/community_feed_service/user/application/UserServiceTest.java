package com.seungwon.community_feed_service.user.application;

import com.seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import com.seungwon.community_feed_service.user.application.interfaces.UserRepository;
import com.seungwon.community_feed_service.user.domain.User;
import com.seungwon.community_feed_service.user.domain.UserInfo;
import com.seungwon.community_feed_service.user.repository.FakeUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    private final UserRepository userRepository = new FakeUserRepository();
    private final UserService userService = new UserService(userRepository);

    @Test
    void givenUserInfoDto_whenCreateUser_thenCanFindUser() {
        // Given
        CreateUserRequestDto dto = new CreateUserRequestDto("test", "");

        // When
        User saveUser = userService.createUser(dto);

        // Then
        User foundUser = userService.getUser(saveUser.getId());
        UserInfo userInfo = foundUser.getUserInfo();
        assertEquals(foundUser.getId(), saveUser.getId());
        assertEquals("test", userInfo.getName());
    }
}
