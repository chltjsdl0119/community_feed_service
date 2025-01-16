package seungwon.community_feed_service.user.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seungwon.community_feed_service.common.ui.Response;
import seungwon.community_feed_service.user.application.UserRelationService;
import seungwon.community_feed_service.user.application.dto.FollowUserRequestDto;

@RestController
@RequestMapping("/relation")
@RequiredArgsConstructor
public class UserRelationController {

    private final UserRelationService userRelationService;

    @PostMapping("/follow")
    public Response<Void> followUser(@RequestBody FollowUserRequestDto dto) {
        userRelationService.follow(dto);
        return Response.ok(null);
    }

    @PostMapping("/unfollow")
    public Response<Void> unfollowUser(@RequestBody FollowUserRequestDto dto) {
        userRelationService.unfollow(dto);
        return Response.ok(null);
    }
}
