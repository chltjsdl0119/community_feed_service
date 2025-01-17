package seungwon.community_feed_service.user.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seungwon.community_feed_service.common.ui.Response;
import seungwon.community_feed_service.user.application.UserService;
import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.application.dto.GetUserListResponseDto;
import seungwon.community_feed_service.user.domain.User;
import seungwon.community_feed_service.user.repository.jpa.JpaUserListQueryRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JpaUserListQueryRepository jpaUserListQueryRepository;

    @PostMapping
    public Response<Long> createUser(@RequestBody CreateUserRequestDto dto) {
        User user = userService.createUser(dto);
        return Response.ok(user.getId());
    }

    @GetMapping("/{userId}/following")
    public Response<List<GetUserListResponseDto>> getFollowingList(@PathVariable(name = "userId")Long userId) {
        List<GetUserListResponseDto> result = jpaUserListQueryRepository.getFollowingUserList(userId);
        return Response.ok(result);
    }
}
