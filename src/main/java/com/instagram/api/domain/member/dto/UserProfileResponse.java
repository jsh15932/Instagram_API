package com.instagram.api.domain.member.dto;

import com.instagram.api.global.vo.Image;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponse {

    private String memberUsername;

    private String memberName;

    private String memberWebsite;

    private Image memberImage;

    private boolean isFollowing;

    private boolean isFollower;

    private boolean isBlocking;

    private boolean isBlocked;

    private String memberIntroduce;

    private Long memberPostsCount;

    private Long memberFollowingsCount;

    private Long memberFollowersCount;

    private String followingMemberFollow;

    private boolean isMe;

    private boolean hasStory;

    @QueryProjection
    public UserProfileResponse(String username, String name, String website,
                               Image image, boolean isFollowing, boolean isFollower,
                               boolean isBlocking, boolean isBlocked, String introduce,
                               Long postsCount, Long followingsCount, Long followersCount, boolean isMe) {
        this.memberUsername = username;
        this.memberName = name;
        this.memberWebsite = website;
        this.memberImage = image;
        this.isFollowing = isFollowing;
        this.isFollower = isFollower;
        this.isBlocking = isBlocking;
        this.isBlocked = isBlocked;
        this.memberIntroduce = introduce;
        this.memberPostsCount = postsCount;
        this.memberFollowingsCount = followingsCount;
        this.memberFollowersCount = followersCount;
        this.isMe = isMe;
        this.hasStory = false;
    }

    public void checkBlock() {
        if(this.isBlocked || this.isBlocking) {
            this.memberPostsCount = 0L;
            this.memberFollowingsCount = 0L;
            this.memberFollowersCount = 0L;
        }
    }

    public void setFollowingMemberFollow(String followingMemberFollow) {
        this.followingMemberFollow = followingMemberFollow;
    }
}
