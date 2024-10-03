package com.seungwon.community_feed_service.user.domain;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final UserRelationCounter followingCounter;
    private final UserRelationCounter followerCounter;


    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.userInfo = userInfo;
        this.followingCounter = new UserRelationCounter();
        this.followerCounter = new UserRelationCounter();
    }

    public void follow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        this.followingCounter.increase();
        targetUser.increaseFollowerCounter();
    }

    public void unfollow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        this.followingCounter.decrease();
        targetUser.decreaseFollowerCounter();
    }

    private void increaseFollowerCounter() {
        this.followingCounter.increase();
    }

    private void decreaseFollowerCounter() {
        this.followerCounter.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
