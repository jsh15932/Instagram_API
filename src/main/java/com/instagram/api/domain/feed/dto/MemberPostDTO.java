package com.instagram.api.domain.feed.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPostDTO {

    private Long postId;
    private String postImageUrl;
    private boolean hasManyPosts;
    private int postCommentsCount;
    private int postLikesCount;

    @Builder
    @QueryProjection
    public MemberPostDTO(Long postId, boolean hasManyPosts, int postCommentsCount, int postLikesCount) {
        this.postId = postId;
        this.hasManyPosts = hasManyPosts;
        this.postCommentsCount = postCommentsCount;
        this.postLikesCount = postLikesCount;
    }

    public void setImageUrl(String imageUrl) {
        this.postImageUrl = imageUrl;
    }
}
