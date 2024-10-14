package com.seungwon.community_feed_service.user.application.interfaces;

import com.seungwon.community_feed_service.user.domain.User;

public interface UserRelationRepository {
    boolean isAlreadyFollowed(User user, User targetUser);
    void save(User user, User targetUser);
    void delete(User user, User targetUser);
}
