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

    @GetMapping("/findPostsByCategory/{categoryId}")
    public String findPostsByCategory(@PathVariable Integer categoryId, Model model){
        model.addAttribute("posts", postService.findAllByCategoryId(categoryId));
        return "home/category";
    }
}
