package seungwon.community_feed_service.post.application;

import seungwon.community_feed_service.fake.FakeObjectFactory;
import seungwon.community_feed_service.post.application.dto.CreateCommentRequestDto;
import seungwon.community_feed_service.post.application.dto.CreatePostRequestDto;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.PostPublicationState;
import seungwon.community_feed_service.user.application.UserService;
import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.domain.User;

public class PostApplicationTestTemplate {

    final UserService userService = FakeObjectFactory.getUserService();
    final PostService postService = FakeObjectFactory.getPostService();
    final CommentService commentService = FakeObjectFactory.getCommentService();

    final User user = userService.createUser(new CreateUserRequestDto("user1", null));
    final User otherUser = userService.createUser(new CreateUserRequestDto("user1", null));

    CreatePostRequestDto postRequestDto = new CreatePostRequestDto(user.getId(), "this is test content", PostPublicationState.PUBLIC);
    final Post post = postService.createPost(postRequestDto);

    final String commentContentText = "this is test comment";
    CreateCommentRequestDto commentRequestDto = new CreateCommentRequestDto(post.getId(), user.getId(), "this is test comment");
}
