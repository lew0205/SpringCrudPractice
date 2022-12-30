package com.crud.crudPractice.domain.post.presentation;

import com.crud.crudPractice.domain.post.Post;
import com.crud.crudPractice.domain.post.presentation.dto.PostDto;
import com.crud.crudPractice.domain.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
public class PostController {

    private final PostService postService;

    @GetMapping("/new")
    public String createForm() {
        return "createPostForm";
    }

    @PostMapping("/new")
    public String create(PostDto postDto) {

        postService.submit(postDto);

        return "redirect:/";
    }

    @GetMapping("")
    public String list(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "board";
    }
}