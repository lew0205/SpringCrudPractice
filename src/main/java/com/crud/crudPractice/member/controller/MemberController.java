package com.crud.crudPractice.member.controller;

import com.crud.crudPractice.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberRepository memberRepository;

    @PostMapping("/join")
    public void join(){
    }
}
