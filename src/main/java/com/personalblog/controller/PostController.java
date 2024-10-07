package com.personalblog.controller;

import com.personalblog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return "/posts/home";
    }
}
