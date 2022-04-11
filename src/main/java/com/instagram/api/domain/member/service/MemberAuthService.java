package com.instagram.api.domain.member.service;

import com.instagram.api.domain.member.dto.RegisterRequest;
import com.instagram.api.domain.member.entity.Member;
import com.instagram.api.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberAuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public boolean register(RegisterRequest registerRequest) {
        if(memberRepository.existsByUsername(registerRequest.getUsername())) {
            throw new Error();
        }

        String username = registerRequest.getUsername();
        Member member = registerRequest.convert();
        String encryptedPassword = bCryptPasswordEncoder.encode(member.getPassword());
        member.setEncryptedPassword(encryptedPassword);
        memberRepository.save(member);

        return true;
    }
}
