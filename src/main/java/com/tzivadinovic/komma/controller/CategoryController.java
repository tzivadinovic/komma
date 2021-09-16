package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/new-post")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/home/new-post";
    }
}
