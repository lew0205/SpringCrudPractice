package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        //given
        MemberDto memberDto = new MemberDto("email@gamil.com", "userA", "010-1234-5678", 20L);

        //when
        Member result = memberService.join(memberDto);

        //then
        assertThat(result.getEmail()).isEqualTo("email@gamil.com");
        assertThat(result.getName()).isEqualTo("userA");
        assertThat(result.getPhoneNum()).isEqualTo("010-1234-5678");
        assertThat(result.getAge()).isEqualTo(20L);
    }

    @Test
    public void findAll(){
        //given
        MemberDto memberDto1 = new MemberDto("email1@gamil.com", "userA", "010-1234-5678", 20L);
        MemberDto memberDto2 = new MemberDto("email2@gamil.com", "userB", "010-2234-5678", 20L);
        MemberDto memberDto3 = new MemberDto("email3@gamil.com", "userC", "010-3234-5678", 20L);
        MemberDto memberDto4 = new MemberDto("email4@gamil.com", "userD", "010-4234-5678", 20L);

        Member member1 = memberService.join(memberDto1);
        Member member2 = memberService.join(memberDto2);
        Member member3 = memberService.join(memberDto3);
        Member member4 = memberService.join(memberDto4);
        List<Member> members= new ArrayList<>();
        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);

        //when
        List<Member> result = memberService.findMembers();

        //then
        assertThat(result.size()).isEqualTo(4);
        for(Member member : members)
        assertThat(result.contains(member));
    }
}
