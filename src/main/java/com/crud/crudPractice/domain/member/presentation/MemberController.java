package com.crud.crudPractice.domain.member.presentation;

import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignInReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.service.MemberSignInService;
import com.crud.crudPractice.domain.member.service.MemberSignUpService;
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

    private final MemberSignUpService memberSignUpService;
    private final MemberSignInService memberSignInService;

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody MemberSignUpReqDto memberSignUpReqDto) {
        memberSignUpService.execute(memberSignUpReqDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> signIn(@Valid @RequestBody MemberSignInReqDto memberSignInReqDto) {

    }
}
