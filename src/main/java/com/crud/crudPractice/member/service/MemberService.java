package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberDto;

import java.util.List;

public interface MemberService {

    Member join(MemberDto memberDto);

    List<Member> findMembers();

    Member findMemberById(Long id);

    Member findMemberByName(String name);

    void deleteOne(Long id);

    void deleteAll();
}
