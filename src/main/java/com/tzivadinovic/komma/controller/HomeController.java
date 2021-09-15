package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.domain.CustomPageImpl;
import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PostService postService;

    @RequestMapping("/home")
    public String home(Model model, @RequestParam(required = false) String page, @RequestParam(required = false) String size) {
        int pageNumber = 0;
        try {
            pageNumber = Integer.parseInt(page);
        } catch (NumberFormatException ignored) {
        }
        int sizeCount = 4;
        try {
            sizeCount = Integer.parseInt(size);
        } catch (NumberFormatException ignored) {
        }
        model.addAttribute("posts", postService.findAll(PageRequest.of(pageNumber, sizeCount)));
        return "home/home";
    }

    @GetMapping("/post/{postId}")
    public String post(Model model, @PathVariable Integer postId) {
        model.addAttribute("post", postService.findById(postId));
        return "home/post";
    }
}
