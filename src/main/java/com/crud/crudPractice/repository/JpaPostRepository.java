package com.crud.crudPractice.repository;

import com.crud.crudPractice.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPostRepository extends JpaRepository<Post, Long>, PostRepository {

}
