package com.crud.crudPractice.member.repository;

import com.crud.crudPractice.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
