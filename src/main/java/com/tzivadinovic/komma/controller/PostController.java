package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.PostDTO;
import com.tzivadinovic.komma.security.annotation.RequireAdmin;
import com.tzivadinovic.komma.service.CategoryService;
import com.tzivadinovic.komma.service.PostService;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;
    private final TagService tagService;

    @RequestMapping("/new-post")
    public String newPost() {
        return "home/new-post";
    }

    @PostMapping("/create-post")
    public String createPost(@AuthenticationPrincipal User user,
                             @ModelAttribute PostDTO post,
                             Model model) {
        model.addAttribute("post", postService.save(post, user));
        return "redirect:/home";
    }

    @RequireAdmin
    @PostMapping("/update-post-status/{postId}")
    public String updatePostStatus(@PathVariable Integer postId) {
        postService.updatePostStatus(postId);
        return "redirect:/dashboard/posts";
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

    @GetMapping("/my-posts")
    public String findPostsByUsername(@AuthenticationPrincipal User user,
                                      Model model,
                                      @RequestParam(required = false) String page,
                                      @RequestParam(required = false) String size) {
        int pageNumber = 0;
        try {
            pageNumber = Integer.parseInt(page);
        } catch (NumberFormatException ignored) {
        }
        int sizeCount = 5;
        try {
            sizeCount = Integer.parseInt(size);
        } catch (NumberFormatException ignored) {
        }
        model.addAttribute("userPosts", postService.findAllByUsername(user.getUsername(), PageRequest.of(pageNumber, sizeCount)));
        return "home/my-posts";
    }

    @RequireAdmin
    @PostMapping("/update-post")
    public String updatePost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("", postService.update(post));
        return "redirect:/dashboard/posts";
    }

    @RequireAdmin
    @GetMapping("/posts/{id}")
    public String getUpdatingPost(Model model,
                                  @PathVariable Integer id) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("possibleTags", tagService.findAll());
        return "dashboard/update-delete-post";
    }
}
