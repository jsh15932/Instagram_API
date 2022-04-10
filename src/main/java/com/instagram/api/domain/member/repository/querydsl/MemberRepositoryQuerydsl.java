package com.instagram.api.domain.member.repository.querydsl;

import com.instagram.api.domain.member.dto.MiniProfileResponse;
import com.instagram.api.domain.member.dto.UserProfileResponse;
import com.instagram.api.domain.member.entity.Member;

import java.util.List;

public interface MemberRepositoryQuerydsl {

    UserProfileResponse getUserProfile(Long loginUserId, String username);
    MiniProfileResponse getMiniProfile(Long loginUserId, String username);
    List<Member> findAllByUsernames(List<String> usernames);
}
