package com.crud.crudPractice.member.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberForm;
import com.crud.crudPractice.post.domain.Post;

import java.util.List;

public interface MemberService {

    Member join(MemberForm memberForm);

    List<Member> findMembers();

    Member findMemberById(Long id);

    Member findMemberByName(String name);
}
