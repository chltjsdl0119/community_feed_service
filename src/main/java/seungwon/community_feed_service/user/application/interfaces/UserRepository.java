package seungwon.community_feed_service.user.application.interfaces;

import seungwon.community_feed_service.user.domain.User;

public interface UserRepository {

    User save(User user);
    User findById(Long id);
}
