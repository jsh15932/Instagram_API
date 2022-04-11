package com.instagram.api.domain.member.service;

import com.instagram.api.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

        private final MemberRepository memberRepository;

        private final S3Uploader s3Uploader;
}
