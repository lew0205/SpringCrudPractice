package com.crud.crudPractice.domain.member.presentation;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.presentation.dto.MemberDto;
import com.crud.crudPractice.domain.member.service.MemberService;
import com.crud.crudPractice.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void signUp()
}
