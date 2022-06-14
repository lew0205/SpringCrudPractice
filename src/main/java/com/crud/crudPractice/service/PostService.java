package com.crud.crudPractice.service;

import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long submit(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findOne(Long postIdx) {
        return postRepository.findById(postIdx).orElseThrow(()-> new RuntimeException());
    }

    public List<Post> findByTitle(String postingTitle){
        return postRepository.findAllByTitle(postingTitle);
    }
}
