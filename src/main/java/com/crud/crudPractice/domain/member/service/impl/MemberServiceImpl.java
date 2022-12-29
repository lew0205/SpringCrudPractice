package com.crud.crudPractice.domain.member.service.impl;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.MemberDto;
import com.crud.crudPractice.domain.member.repository.MemberRepository;
import com.crud.crudPractice.domain.member.service.MemberService;
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
        return memberRepository.save(memberDto.toEntity());
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
