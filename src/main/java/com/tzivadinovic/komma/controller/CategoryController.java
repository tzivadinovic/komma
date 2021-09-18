package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Category;
import com.tzivadinovic.komma.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/new-post")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/home/new-post";
    }

    @PostMapping("/save-category")
    public String saveCategory(Model model, Category category) {
        model.addAttribute("category", categoryService.save(category));
        return "redirect:/dashboard";
    }

    @PostMapping("/update-category/{id}")
    public String updateCategory(Model model, @PathVariable Integer id, @Validated @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "error";
        category.setId(id);
        model.addAttribute("category", categoryService.update(category));
        return "redirect:/dashboard";
    }

    @GetMapping("/update-category/{id}")
    public String getUpdatingCategory(Model model, @PathVariable Integer id) {
        model.addAttribute("category", categoryService.findById(id));
        return "home/dashboard";
    }
}
