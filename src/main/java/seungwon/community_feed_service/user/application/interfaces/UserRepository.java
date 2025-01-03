package seungwon.community_feed_service.user.application.interfaces;

import seungwon.community_feed_service.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long id);
}
