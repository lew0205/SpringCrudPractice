package com.crud.crudPractice.domain.member.service;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.MemberDto;

import java.util.List;

public interface MemberService {

    Member join(MemberDto memberDto);

    List<Member> findMembers();

    Member findMemberById(Long id);

    Member findMemberByName(String name);

    void deleteOne(Long id);

    void deleteAll();
}
