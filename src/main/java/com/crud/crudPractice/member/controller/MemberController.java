package com.crud.crudPractice.member.controller;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberForm;
import com.crud.crudPractice.member.repository.MemberRepository;
import com.crud.crudPractice.member.service.MemberService;
import com.crud.crudPractice.post.domain.Post;
import com.crud.crudPractice.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final PostService postService;

    @PostMapping("/join")
    public Member join(@RequestBody MemberForm memberForm) {
        Member member = new Member();

        member.setName(memberForm.getName());
        member.setPhoneNum(memberForm.getPhoneNum());
        member.setAge(memberForm.getAge());
        List<Post> adf;
        for(Long id : memberForm.getPostIds()){
            member.getPosts().add(postService.findOne(id));
        }

        memberService.join(member);

        return member;
    }

    @GetMapping("/id/{memberId}")
    public Member findMemberId(@PathVariable Long memberId) {
        Member result = memberService.findMemberById(memberId);
        return result;
    }

    @GetMapping("/name/{memberName}")
    public Member findMemberName(@PathVariable String memberName) {
        Member result = memberService.findMemberByName(memberName);
        return result;
    }

    @GetMapping
    public List<Member> memberList() {
        List<Member> members = memberService.findMembers();
        return members;
    }
}
