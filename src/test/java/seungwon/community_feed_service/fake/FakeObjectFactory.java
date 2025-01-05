package seungwon.community_feed_service.fake;

import seungwon.community_feed_service.post.application.CommentService;
import seungwon.community_feed_service.post.application.PostService;
import seungwon.community_feed_service.post.application.interfaces.CommentRepository;
import seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import seungwon.community_feed_service.post.application.interfaces.PostRepository;
import seungwon.community_feed_service.post.repository.FakeCommentRepository;
import seungwon.community_feed_service.post.repository.FakeLikeRepository;
import seungwon.community_feed_service.post.repository.FakePostRepository;
import seungwon.community_feed_service.user.application.UserRelationService;
import seungwon.community_feed_service.user.application.UserService;
import seungwon.community_feed_service.user.application.interfaces.UserRelationRepository;
import seungwon.community_feed_service.user.application.interfaces.UserRepository;
import seungwon.community_feed_service.user.repository.FakeUserRelationRepository;
import seungwon.community_feed_service.user.repository.FakeUserRepository;

public class FakeObjectFactory {

    private static final UserRepository fakeUserRepository = new FakeUserRepository();
    private static final UserRelationRepository fakeUserRelationRepository = new FakeUserRelationRepository();
    private static final PostRepository fakePostRepository = new FakePostRepository();
    private static final CommentRepository fakeCommentRepository = new FakeCommentRepository();
    private static final LikeRepository fakeLikeRepository = new FakeLikeRepository();

    private static final UserService userService = new UserService(fakeUserRepository);
    private static final UserRelationService userRelationService = new UserRelationService(userService, fakeUserRelationRepository);
    private static final PostService postService = new PostService(userService, fakePostRepository, fakeLikeRepository);
    private static final CommentService commentService = new CommentService(fakeCommentRepository, userService, postService, fakeLikeRepository);

    public static UserService getUserService() {
        return userService;
    }

    public static UserRelationService getUserRelationService() {
        return userRelationService;
    }

    public static PostService getPostService() {
        return postService;
    }

    public static CommentService getCommentService() {
        return commentService;
    }
}
