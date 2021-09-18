package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.PostDTO;
import com.tzivadinovic.komma.repository.TagRepository;
import com.tzivadinovic.komma.service.CategoryService;
import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TagRepository tagRepository;
    private final CategoryService categoryService;

    @RequestMapping("/new-post")
    public String newPost() {
        return "home/new-post";
    }

    @PostMapping("/createPost")
    public String createPost(@AuthenticationPrincipal User user,
                             @ModelAttribute PostDTO dto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) return "";
        model.addAttribute("post", postService.save(dto, user));
        return "home/home";
    }

    @GetMapping("/categories/{category}")
    public String findPostsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("categoryPosts", postService.findAllByCategory(category));
        model.addAttribute("categoryName", category);
        return "home/posts-by-category";
    }

    @GetMapping("/tags/{tag}")
    public String findPostsByTag(@PathVariable String tag, Model model) {
        model.addAttribute("tagPosts", postService.findAllByTags(tag));
        model.addAttribute("tagName", tag);
        return "home/posts-by-tag";
    }

    @GetMapping("/my-posts/{username}")
    public String findPostsByUsername(@PathVariable String username, Model model) {
        model.addAttribute("userPosts", postService.findAllByUsername(username));
        return "home/my-posts";
    }
}
