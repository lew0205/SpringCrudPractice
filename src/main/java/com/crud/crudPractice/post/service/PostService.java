package com.crud.crudPractice.post.service;

import com.crud.crudPractice.post.domain.Post;

import java.util.List;

public interface PostService {
    Long submit(Post post);

    List<Post> findPosts();

    Post findOne(Long postIdx);

    List<Post> findByTitle(String postingTitle);
}
