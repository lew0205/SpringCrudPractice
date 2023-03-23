package com.crud.crudPractice.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 4xx
    WRONG_PW("잘못된 비밀번호입니다", 403),

    MEMBER_NOT_FOUND("이메일 주소를 확인해주세요", 404),

    // 5xx
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500),
    ;

    private String msg;
    private int code;
}
