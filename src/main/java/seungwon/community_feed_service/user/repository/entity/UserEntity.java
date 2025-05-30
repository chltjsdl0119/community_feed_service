package seungwon.community_feed_service.user.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import seungwon.community_feed_service.common.domain.PositiveIntegerCounter;
import seungwon.community_feed_service.common.repository.entity.TimeBaseEntity;
import seungwon.community_feed_service.user.domain.User;
import seungwon.community_feed_service.user.domain.UserInfo;

@Entity
@Table(name="community_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@DynamicUpdate
public class UserEntity extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String profileImage;
    private Integer followerCount;
    private Integer followingCount;

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.followerCount = user.getFollowerCount();
        this.followingCount = user.getFollowingCount();
    }

    public User toUser() {
        return User.builder()
                .id(id)
                .userInfo(new UserInfo(name, profileImage))
                .followerCounter(new PositiveIntegerCounter(followerCount))
                .followingCounter(new PositiveIntegerCounter(followingCount))
                .build();
    }
}