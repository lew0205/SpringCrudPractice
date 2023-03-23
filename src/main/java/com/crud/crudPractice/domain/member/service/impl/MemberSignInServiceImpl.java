package com.crud.crudPractice.domain.member.service.impl;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.exception.MemberNotFoundException;
import com.crud.crudPractice.domain.member.exception.WrongPasswordException;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignInReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.res.MemberSignInResDto;
import com.crud.crudPractice.domain.member.repository.MemberRepository;
import com.crud.crudPractice.domain.member.service.MemberSignInService;
import com.crud.crudPractice.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignInServiceImpl implements MemberSignInService {

    MemberRepository memberRepository;
    PasswordEncoder passwordEncoder;
    TokenProvider tokenProvider;

    @Override
    public MemberSignInResDto execute(MemberSignInReqDto req) {
        Member member = memberRepository.findByEmail(req.getEmail())
            .orElseThrow(MemberNotFoundException::new);
        if (member != null) {
            if (!passwordEncoder.matches(req.getPassword(), member.getPassword())) {
                throw new WrongPasswordException();
            }
        }
        String accessToken = tokenProvider.generateAccessToken(member.getEmail());
        String refreshToken = tokenProvider.generateRefreshToken(member.getEmail());

        return new MemberSignInResDto(
            accessToken,
            refreshToken,
            tokenProvider.getAccessExpiredTime()
        );
    }
}
