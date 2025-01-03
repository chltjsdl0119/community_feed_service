package seungwon.community_feed_service.user.application.interfaces;

import seungwon.community_feed_service.user.domain.User;

public interface UserRelationRepository {

    boolean isAlreadyFollowed(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);
}
