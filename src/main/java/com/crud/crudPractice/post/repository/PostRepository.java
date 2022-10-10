package com.crud.crudPractice.post.repository;

import com.crud.crudPractice.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByTitle(String title);

    List<Post> findAllByAuthor(String authorName);
}
