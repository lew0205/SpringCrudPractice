package com.crud.crudPractice.post.service;

import com.crud.crudPractice.member.domain.Member;
import com.crud.crudPractice.post.domain.Post;
import com.crud.crudPractice.post.domain.PostDto;

import java.util.List;

public interface PostService {
    Long submit(PostDto postDto);

    List<Post> findPosts();

    Post findOne(Long postIdx);

    List<Post> findByTitle(String postingTitle);

    List<Post> findByAuthor(Member author);
}
