package com.crud.crudPractice.domain.member.service.impl;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.repository.MemberRepository;
import com.crud.crudPractice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Member join(MemberSignUpReqDto memberSignUpReqDto) {
        return memberRepository.save(memberSignUpReqDto.toEntity(passwordEncoder.encode(memberSignUpReqDto.getPassword())));
    }
}
