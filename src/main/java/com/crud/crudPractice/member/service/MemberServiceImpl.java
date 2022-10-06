package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberForm;
import com.crud.crudPractice.member.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Member join(MemberForm memberForm) {
        Member member = new Member();

        member.setName(memberForm.getName());
        member.setPhoneNum(memberForm.getPhoneNum());
        member.setAge(memberForm.getAge());

        memberRepository.save(member);
        return member;
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Member findMemberByName(String name) {
        return memberRepository.findByName(name);
    }
}
