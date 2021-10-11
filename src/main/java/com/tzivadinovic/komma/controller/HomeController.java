package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.*;
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
    private final UserService userService;
    private final TagService tagService;
    private final CategoryService categoryService;
    private final RoleService roleService;
    private final CommentService commentService;

    @RequestMapping("/home")
    public String home(Model model,
                       @RequestParam(required = false) String page,
                       @RequestParam(required = false) String size) {
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
    public String post(Model model,
                       @PathVariable Integer postId) {
        model.addAttribute("post", postService.findById(postId));
        model.addAttribute("comments", commentService.findAllByPostId(postId));
        return "home/post";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "home/dashboard";
    }

    @GetMapping("/dashboard/posts")
    public String dashboardPosts(Model model,
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
        model.addAttribute("dashPosts", postService.findAllForAdmin(PageRequest.of(pageNumber, sizeCount)));
        return "dashboard/posts";
    }


}
