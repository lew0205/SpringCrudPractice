package com.crud.crudPractice.domain.member.presentation.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.crud.crudPractice.domain.member.Member;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignUpReqDto {

    @Email
    @NotBlank
    @Pattern(regexp = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")
    String email;
    @NotBlank
    String name;
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자, 최대 20자입니다")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\\\d)(?=.*\\\\W).{8,20}$", message = "비밀번호는 대문자,소문자,숫자,특수문자로 이루어져야합니다.")
    @NotBlank
    String password;

    public Member toEntity(String password) {
        return Member.builder()
            .email(email)
            .name(name)
            .password(password)
            .build();
    }
}
