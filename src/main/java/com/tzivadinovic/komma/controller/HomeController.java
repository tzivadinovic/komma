package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService postService;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "home/home";
    }
}
