package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberDto;
import com.crud.crudPractice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Member join(MemberDto memberDto) {
        Member member = memberDto.toEntity();

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

    @Override
    public void deleteOne(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        memberRepository.deleteAll();
    }
}
