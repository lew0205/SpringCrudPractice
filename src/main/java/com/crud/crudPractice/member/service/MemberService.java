package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;

import java.util.List;

public interface MemberService {

    Member join(Member member);

    List<Member> findMembers();

    Member findMemberById(Long id);

    Member findMemberByName(String name);
}
