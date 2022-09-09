package com.crud.crudPractice.post.controller;

import com.crud.crudPractice.post.domain.Post;
import com.crud.crudPractice.post.domain.PostForm;
import com.crud.crudPractice.post.service.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

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