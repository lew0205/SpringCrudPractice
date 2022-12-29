package com.crud.crudPractice.domain.post.service;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.domain.post.presentation.dto.PostDto;

import java.util.List;

public interface PostService {
    Post submit(PostDto postDto);

    List<Post> findPosts();

    Post findOne(Long postIdx);

    List<Post> findByTitle(String postingTitle);

    List<Post> findByAuthor(Member author);

    void deleteOne(Long id);

    void deleteAll();
}
