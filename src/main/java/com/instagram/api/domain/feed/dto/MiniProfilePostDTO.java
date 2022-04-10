package com.instagram.api.domain.feed.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MiniProfilePostDTO {

    private Long postId;

    private String postImageUrl;

    @Builder
    @QueryProjection
    public MiniProfilePostDTO(Long postId, String postImageUrl) {
        this.postId = postId;
        this.postImageUrl = postImageUrl;
    }
}
