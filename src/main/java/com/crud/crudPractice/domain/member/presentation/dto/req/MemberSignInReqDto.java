package com.crud.crudPractice.domain.member.presentation.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignInReqDto {

    private String email;
    private String password;
}
