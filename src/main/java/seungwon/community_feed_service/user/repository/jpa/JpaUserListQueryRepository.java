package seungwon.community_feed_service.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seungwon.community_feed_service.user.application.dto.GetUserListResponserDto;
import seungwon.community_feed_service.user.repository.entity.UserEntity;

import java.util.List;

public interface JpaUserListQueryRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT new seungwon.community_feed_service.user.application.dto.GetUserListResponserDto(u.name, u.profileImage)"
            + "FROM UserRelationEntity ur "
            + "INNER JOIN UserEntity u ON ur.followerUserId = u.id "
            + "WHERE ur.followingUserId = :userId")
    List<GetUserListResponserDto> getFollowingUserList(Long userId);

    @Query(value = "SELECT new seungwon.community_feed_service.user.application.dto.GetUserListResponserDto(u.name, u.profileImage) "
            + "FROM UserRelationEntity ur "
            + "INNER JOIN UserEntity u ON ur.followingUserId = u.id "
            + "WHERE ur.followerUserId = :userId")
    List<GetUserListResponserDto> getFollowerUserList(Long userId);
}
