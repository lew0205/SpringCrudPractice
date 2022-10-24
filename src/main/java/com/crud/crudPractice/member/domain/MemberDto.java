package com.crud.crudPractice.member.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    String email;
    String name;
    String phoneNum;
    Long age;

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .name(name)
                .age(age)
                .phoneNum(phoneNum)
                .build();
    }
}
