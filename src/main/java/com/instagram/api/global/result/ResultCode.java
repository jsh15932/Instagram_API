package com.instagram.api.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // 회원
    REGISTER_SUCCESS(200, "M001", "회원가입 되었습니다."),
    CONFIRM_EMAIL_FAIL(200, "M013", "이메일 인증을 완료할 수 없습니다. 인증코드를 다시확인 해주세요"),
        ;

    private int status;
    private final String code;
    private final String message;
}
