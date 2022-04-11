package com.instagram.api.domain.member.controller;

import com.instagram.api.domain.member.dto.RegisterRequest;
import com.instagram.api.domain.member.service.MemberAuthService;
import com.instagram.api.global.result.ResultCode;
import com.instagram.api.global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class MemberAuthController {

    private final MemberAuthService memberAuthService;

    @PostMapping(value = "/regist")
    public ResponseEntity<ResultResponse> register(@Validated @RequestBody RegisterRequest registerRequest) {
        boolean isRegistered = memberAuthService.register(registerRequest);
        ResultResponse result;
        if(isRegistered) {
            result = ResultResponse.of(ResultCode.REGISTER_SUCCESS, true);
        } else {
            result = ResultResponse.of(ResultCode.CONFIRM_EMAIL_FAIL, false);
        }
        return new ResponseEntity<>(result, HttpStatus.valueOf(result.getStatus()));
    }
}