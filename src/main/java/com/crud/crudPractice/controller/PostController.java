package com.crud.crudPractice.controller;

import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    public PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/board/new")
    public String createForm() {
        return "createPostForm";
    }

    @PostMapping("/board/new")
    public String create(PostForm form) {
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setAuthor(form.getAuthor());

        postService.submit(post);

        return "redirect:/";
    }

    @GetMapping("/board")
    public String list(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "board";
    }
}