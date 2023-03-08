package com.crud.crudPractice.domain.member.service;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.MemberSignUpReqDto;

public interface MemberService {

    Member join(MemberSignUpReqDto memberSignUpReqDto);

}
