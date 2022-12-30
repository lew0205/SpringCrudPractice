package com.crud.crudPractice.domain.member.presentation.dto;

import lombok.*;
import com.crud.crudPractice.domain.member.Member;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    String email;
    String name;
    String phoneNum;
    int age;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .age(age)
                .phoneNum(phoneNum)
                .build();
    }
}
