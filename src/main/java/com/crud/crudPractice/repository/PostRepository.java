package com.crud.crudPractice.repository;

import com.crud.crudPractice.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> FindById(Long id);

    Optional<Post> FindByTitle(String title);

    List<Post> FindAll();
}
