package com.personalblog.controller;

import com.personalblog.entity.User;
import com.personalblog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @GetMapping("/record")
    public String recordPage() {
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "/users/login";
    }
}
