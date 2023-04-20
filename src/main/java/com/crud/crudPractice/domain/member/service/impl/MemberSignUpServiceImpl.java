package com.crud.crudPractice.domain.member.service.impl;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.repository.MemberRepository;
import com.crud.crudPractice.domain.member.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberSignUpServiceImpl implements MemberSignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Member execute(MemberSignUpReqDto memberSignUpReqDto) {
        return memberRepository.save(memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.getPassword())));
    }
}
