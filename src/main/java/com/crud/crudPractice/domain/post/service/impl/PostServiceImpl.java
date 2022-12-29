package com.crud.crudPractice.domain.post.service.impl;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.member.service.MemberService;
import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.domain.post.presentation.dto.PostDto;
import com.crud.crudPractice.domain.post.repository.PostRepository;
import com.crud.crudPractice.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    public Post submit(PostDto postDto) {
        Member member = memberService.findMemberById(postDto.getAuthor());
        System.out.println("member = " + member);

        Post post = postDto.toEntity(member);
        postRepository.save(post);
        return post;
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findOne(Long postIdx) {
        return postRepository.findById(postIdx)
                .orElseThrow(() -> new RuntimeException());
    }

    public List<Post> findByTitle(String postingTitle) {
        return postRepository.findAllByTitle(postingTitle);
    }

    @Override
    public List<Post> findByAuthor(Member author) {
        return postRepository.findAllByAuthor(author);
    }

    @Override
    public void deleteOne(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        postRepository.deleteAll();
    }
}
