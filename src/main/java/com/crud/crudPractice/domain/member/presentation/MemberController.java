package com.crud.crudPractice.domain.member.presentation;

import com.crud.crudPractice.domain.member.presentation.dto.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody MemberSignUpReqDto memberSignUpReqDto) {
        memberService.join(memberSignUpReqDto);
        return ResponseEntity.ok().build();
    }
}
