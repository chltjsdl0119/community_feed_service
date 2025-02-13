package seungwon.community_feed_service.acceptance.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import seungwon.community_feed_service.user.application.dto.CreateUserRequestDto;
import seungwon.community_feed_service.user.application.dto.FollowUserRequestDto;

import static seungwon.community_feed_service.acceptance.steps.UserAcceptanceSteps.createUser;
import static seungwon.community_feed_service.acceptance.steps.UserAcceptanceSteps.followUser;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    public void loadData() {
        CreateUserRequestDto dto = new CreateUserRequestDto("test user", "");
        createUser(dto);
        createUser(dto);
        createUser(dto);

        followUser(new FollowUserRequestDto(1L, 2L));
        followUser(new FollowUserRequestDto(1L, 3L));
    }

    public String getEmailToken(String email) {
        return entityManager.createNativeQuery("SELECT token FROM community_email_verification WHERE email = ?", String.class)
                .setParameter(1, email)
                .getSingleResult()
                .toString();
    }
}
