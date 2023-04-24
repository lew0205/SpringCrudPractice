package com.crud.crudPractice.Member;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.exception.MemberNotFoundException;
import com.crud.crudPractice.domain.member.exception.WrongPasswordException;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignInReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.res.MemberSignInResDto;
import com.crud.crudPractice.domain.member.repository.MemberRepository;
import com.crud.crudPractice.domain.member.service.MemberSignInService;
import com.crud.crudPractice.domain.member.service.MemberSignUpService;
import com.crud.crudPractice.global.config.security.jwt.JwtProperties;
import com.crud.crudPractice.global.exception.BasicException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
public class MemberTest {


    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberSignUpService memberSignUpService;
    @Autowired
    MemberSignInService memberSignInService;
    @Autowired
    JwtProperties jwtProperties;

    @Test
    @DisplayName("[성공] 회원가입")
    void signUpTest() {
        // given
        String email = "test@test.test";
        String name = "test";
        String password = "password1234";

        // when
        MemberSignUpReqDto memberSignUpReqDto = new MemberSignUpReqDto(email, name, password);
        Member result = memberSignUpService.execute(memberSignUpReqDto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getEmail()).isEqualTo(email);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getPassword()).isNotEqualTo(password);
        assertThat(result.getPosts()).isNull();

        log.info("result.id = {}", result.getId());
        log.info("result.email = {}", result.getEmail());
        log.info("result.password = {}", result.getPassword());
        log.info("result.name = {}", result.getName());
        log.info("result.posts = {}", result.getPosts());
    }

    @Test
    @DisplayName("[성공] 로그인")
    void successSignInTest() {
        // given
        String email = "test@test.test";
        String name = "test";
        String password = "password1234";

        MemberSignUpReqDto memberSignUpReqDto = new MemberSignUpReqDto(email, name, password);
        memberSignUpService.execute(memberSignUpReqDto);

        // when
        MemberSignInReqDto memberSignInReqDto = new MemberSignInReqDto(email, password);
        MemberSignInResDto result = memberSignInService.execute(memberSignInReqDto);

        // then
        assertThat(result).isNotNull();
        log.info("accessToken = {}", result.getAccessToken());
        log.info("refreshToken = {}", result.getRefreshToken());
    }

    @Test
    @DisplayName("[실패] 로그인")
    void failSignUpTest() {
        String email = "test@test.test";
        String name = "test";
        String wrongEmail = "asdfasdf@gmail.com";
        String password = "password1234";
        String wrongPw = "wrongpw1234";

        MemberSignUpReqDto reqDto = new MemberSignUpReqDto(email, password, name);
        memberSignUpService.execute(reqDto);

        BasicException memberException = assertThrows(BasicException.class, () -> memberSignInService.execute(new MemberSignInReqDto(wrongEmail, password)));
        assertThat(memberException).isInstanceOf(MemberNotFoundException.class);

        BasicException passwordException = assertThrows(BasicException.class, () -> memberSignInService.execute(new MemberSignInReqDto(email, wrongPw)));
        assertThat(passwordException).isInstanceOf(WrongPasswordException.class);
    }

    @AfterEach
    void afterEach() {
        memberRepository.deleteAll();
    }
}
