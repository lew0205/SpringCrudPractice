package com.crud.crudPractice.domain.member.exception;

import com.crud.crudPractice.global.exception.BasicException;
import com.crud.crudPractice.global.exception.ErrorCode;

public class WrongPasswordException extends BasicException {
    public WrongPasswordException() {
        super(ErrorCode.WRONG_PW);
    }
}
