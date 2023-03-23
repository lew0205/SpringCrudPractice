package com.crud.crudPractice.domain.member.exception;

import com.crud.crudPractice.global.exception.BasicException;
import com.crud.crudPractice.global.exception.ErrorCode;

public class MemberNotFoundException extends BasicException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
