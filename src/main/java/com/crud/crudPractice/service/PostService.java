package com.crud.crudPractice.service;

import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.repository.PostRepository;

import java.util.List;

public interface PostService {
    Long submit(Post post);

    List<Post> findPosts();

    Post findOne(Long postIdx);

    List<Post> findByTitle(String postingTitle);
}
