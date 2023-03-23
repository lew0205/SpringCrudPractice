package com.crud.crudPractice.domain.member.service;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignUpReqDto;

public interface MemberSignUpService {

    Member execute(MemberSignUpReqDto memberSignUpReqDto);

}
