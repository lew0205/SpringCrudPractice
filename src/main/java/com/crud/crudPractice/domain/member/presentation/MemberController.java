package com.crud.crudPractice.domain.member.presentation;

import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignInReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.req.MemberSignUpReqDto;
import com.crud.crudPractice.domain.member.presentation.dto.res.MemberSignInResDto;
import com.crud.crudPractice.domain.member.service.MemberSignInService;
import com.crud.crudPractice.domain.member.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberSignUpService memberSignUpService;
    private final MemberSignInService memberSignInService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody MemberSignUpReqDto memberSignUpReqDto) {
        memberSignUpService.execute(memberSignUpReqDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public MemberSignInResDto signIn(@Valid @RequestBody MemberSignInReqDto memberSignInReqDto) {
        return memberSignInService.execute(memberSignInReqDto);
    }
}
