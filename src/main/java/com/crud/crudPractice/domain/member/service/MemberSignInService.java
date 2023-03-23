package com.crud.crudPractice.domain.member.service;

import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignInReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.res.MemberSignInResDto;

public interface MemberSignInService {

    MemberSignInResDto execute(MemberSignInReqDto memberSignInReqDto);
}
