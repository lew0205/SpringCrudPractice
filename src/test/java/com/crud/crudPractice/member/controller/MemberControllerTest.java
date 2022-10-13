//package com.crud.crudPractice.member.controller;
//
//import com.crud.crudPractice.member.domain.Member;
//import com.crud.crudPractice.member.domain.MemberForm;
//import com.crud.crudPractice.member.repository.MemberRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.xmlunit.util.Mapper;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class MemberControllerTest {
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void join() {
//        //given
//        String name = "userA";
//        Long age = Long.valueOf(20);
//        String phoneNum = "010-5194-9498";
//        //when
//mapper.writeValueAsString()
//        //then
//
////        MemberForm memberForm = new MemberForm();
////        memberForm.setName("userA");
////        Long l = Long.valueOf(20);
////        memberForm.setAge(l);
////        memberForm.setPhoneNum("010-1234-5678");
////
////        Member result = memberController.join(memberForm);
////
////        Assertions.assertThat(result.getName()).isEqualTo("userA");
//    }
//
//    @Test
//    void findMemberId() {
//    }
//
//    @Test
//    void findMemberName() {
//    }
//
//    @Test
//    void memberList() {
//    }
//}