package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @AfterEach
    public void afterEach(){
        memberService.deleteAll();
    }

    @Test
    public void join(){
        MemberDto memberDto = new MemberDto("email@gamil.com","userA","010-1234-5678",20L);
        Member result = memberService.join(memberDto);

        Assertions.assertThat(result.getEmail()).isEqualTo("email@gamil.com");
        Assertions.assertThat(result.getName()).isEqualTo("userA");
        Assertions.assertThat(result.getPhoneNum()).isEqualTo("010-1234-5678");
        Assertions.assertThat(result.getAge()).isEqualTo(20L);
    }
}
