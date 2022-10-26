package com.crud.crudPractice.post.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.member.domain.MemberDto;
import com.crud.crudPractice.member.service.MemberService;
import com.crud.crudPractice.post.domain.Post;
import com.crud.crudPractice.post.domain.PostDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private MemberService memberService;

    @AfterEach
    public void afterEach(){
        postService.deleteAll();
    }

    @Test
    @Transactional
    public void submit(){
        //given
        MemberDto memberDto = new MemberDto("email@gamil.com", "userA", "010-1234-5678", 20);
        Member member = memberService.join(memberDto);
        Long id = member.getId();
        PostDto postDto = new PostDto("TestArticle","I want to go home",id);
        //when
        Post result = postService.submit(postDto);
        //then
        assertThat(result.getTitle()).isEqualTo("TestArticle");
        assertThat(result.getContent()).isEqualTo("I want to go home");
        assertThat(result.getAuthor().getName()).isEqualTo("userA");
        assertThat(result.getAuthor()).isEqualTo(member);
    }
}
