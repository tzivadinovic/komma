package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Category;
import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.repository.TagRepository;
import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TagRepository tagRepository;

    @RequestMapping("/new-post")
    public String newPost() {
        return "home/new-post";
    }

    @PostMapping("/createPost")
    public String createPost(@Validated Post post, @Validated Category category, @RequestBody List<Tag> tags, BindingResult result) {
        if (result.hasErrors()) return "";
        post.setCategory(category);
        post.setTags(tags);
        postService.save(post);
        return "redirect:/home";
    }

    @GetMapping("/categories/{category}")
    public String findPostsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("categoryPosts", postService.findAllByCategory(category));
        return "home/posts-by-category";
    }

    @GetMapping("/tags/{tag}")
    public String findPostsByTag(@PathVariable String tag, Model model) {
        model.addAttribute("tagPosts", postService.findAllByTags(tag));
        return "home/posts-by-tag";
    }

    @GetMapping("/my-posts/{username}")
    public String findPostsByUsername(@PathVariable String username, Model model) {
        model.addAttribute("userPosts", postService.findAllByUsername(username));
        return "home/my-posts";
    }
}
