package seungwon.community_feed_service.user.repository;

import seungwon.community_feed_service.user.application.interfaces.UserRepository;
import seungwon.community_feed_service.user.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeUserRepository implements UserRepository {

    private final Map<Long, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() != null) {
            store.put(user.getId(), user);
        }

        Long id = store.size() + 1L;
        User newUser = new User(id, user.getUserInfo());
        store.put(id, newUser);

        return newUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}