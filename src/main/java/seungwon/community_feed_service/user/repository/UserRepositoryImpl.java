package seungwon.community_feed_service.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import seungwon.community_feed_service.user.application.interfaces.UserRepository;
import seungwon.community_feed_service.user.domain.User;
import seungwon.community_feed_service.user.repository.entity.UserEntity;
import seungwon.community_feed_service.user.repository.jpa.JpaUserRepository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity(user);
        entity = jpaUserRepository.save(entity);
        return entity.toUser();
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = jpaUserRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return entity.toUser();
    }
}
