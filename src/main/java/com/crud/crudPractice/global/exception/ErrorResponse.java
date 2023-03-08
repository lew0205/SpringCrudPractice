package com.crud.crudPractice.global.exception;

public class ErrorResponse {
    private final String msg;
    private final int code;

    public ErrorResponse(ErrorCode errorCode) {
        this.msg = errorCode.getMsg();
        this.code = errorCode.getCode();
    }
}
