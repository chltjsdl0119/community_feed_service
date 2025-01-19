package seungwon.community_feed_service.post.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.post.application.interfaces.LikeRepository;
import seungwon.community_feed_service.post.domain.Post;
import seungwon.community_feed_service.post.domain.comment.Comment;
import seungwon.community_feed_service.user.domain.User;

@Repository
@RequiredArgsConstructor
public class LikeRepositoryImpl implements LikeRepository {

    @Override
    public boolean checkLike(Post post, User user) {
        return false;
    }

    @Override
    public void like(Post post, User user) {

    }

    @Override
    public void unlike(Post post, User user) {

    }

    @Override
    public boolean checkLike(Comment comment, User user) {
        return false;
    }

    @Override
    public void like(Comment comment, User user) {

    }

    @Override
    public void unlike(Comment comment, User user) {

    }
}
