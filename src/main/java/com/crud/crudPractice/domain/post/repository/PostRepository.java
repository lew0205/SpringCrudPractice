package com.crud.crudPractice.domain.post.repository;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByTitle(String title);

    List<Post> findAllByAuthor(Member author);
}
