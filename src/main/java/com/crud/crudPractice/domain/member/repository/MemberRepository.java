package com.crud.crudPractice.domain.member.repository;

import com.crud.crudPractice.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);
}
