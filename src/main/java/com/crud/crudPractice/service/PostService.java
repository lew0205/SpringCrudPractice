package com.crud.crudPractice.service;

import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long submit(Post post){
        postRepository.save(post);
        return post.getId();
    }

//    public Long<Post>
}
