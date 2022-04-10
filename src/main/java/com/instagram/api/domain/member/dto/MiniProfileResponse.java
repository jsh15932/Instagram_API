package com.instagram.api.domain.member.dto;

import com.instagram.api.domain.feed.dto.MiniProfilePostDTO;
import com.instagram.api.domain.feed.dto.PostImageDTO;
import com.instagram.api.global.vo.Image;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MiniProfileResponse {

    private String memberUsername;

    private Image memberImage;

    private String memberName;

    private String memberWebsite;

    private boolean isFollowing;

    private boolean isFollower;

    private boolean isBlocking;

    private boolean isBlocked;

    private Long memberPostsCount;

    private Long memberFollowingsCount;

    private Long memberFollowersCount;

    private List<MiniProfilePostDTO> memberPosts;

    private String followingMemberFollow;

    private boolean isMe;

    private boolean hasStory;

    @QueryProjection
    public MiniProfileResponse(String username, String name, Image image,
                               boolean isFollowing, boolean isFollower, boolean isBlocking,
                               boolean isBlocked, Long postsCount, Long followingsCount,
                               Long follwersCount, boolean isMe) {
        this.memberUsername = username;
        this.memberName = name;
        this.memberImage = image;
        this.isFollowing = isFollowing;
        this.isFollower = isFollower;
        this.isBlocking = isBlocking;
        this.isBlocked = isBlocked;
        this.memberPostsCount = postsCount;
        this.memberFollowingsCount = followingsCount;
        this.memberFollowersCount = follwersCount;
        this.isMe = isMe;
        this.hasStory = false;
    }

    public void setMemberPosts(List<PostImageDTO> postImageDTOs) {
        final Map<Long, List<PostImageDTO>> postDTOMap = postImageDTOs.stream()
                .collect(Collectors.groupingBy(PostImageDTO::getPostId));
        List<MiniProfilePostDTO> results = new ArrayList<MiniProfilePostDTO>();
        postDTOMap.forEach((id, p) -> results.add(
                MiniProfilePostDTO.builder()
                        .postId(id)
                        .postImageUrl(p.get(0).getPostImageUrl())
                        .build()
        ));
        this.memberPosts = results;
    }

    public void checkBlock() {
        if(this.isBlocked || this.isBlocking) {
            this.memberPostsCount = 0L;
            this.memberFollowersCount = 0L;
            this.memberFollowingsCount = 0L;
            this.memberPosts = null;
        }
    }

    public void setFollowingMemberFollow(String followingMemberFollow) {
        this.followingMemberFollow = followingMemberFollow;
    }
}
