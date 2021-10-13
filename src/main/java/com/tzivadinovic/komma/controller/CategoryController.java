package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Category;
import com.tzivadinovic.komma.security.annotation.RequireAdmin;
import com.tzivadinovic.komma.service.CategoryService;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final TagService tagService;

    @RequireAdmin
    @GetMapping("/dashboard/categories")
    public String getCategoriesOnDashboard(Model model,
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
        model.addAttribute("dashCategories", categoryService.findAll(PageRequest.of(pageNumber, sizeCount)));
        return "dashboard/categories";
    }

    @GetMapping("/new-post")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "/home/new-post";
    }

    @RequireAdmin
    @PostMapping("/save-category")
    public String saveCategory(Model model, Category category) {
        model.addAttribute("category", categoryService.save(category));
        return "redirect:/dashboard/categories";
    }

    @RequireAdmin
    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/dashboard/categories";
    }

    @RequireAdmin
    @GetMapping("/category/{id}")
    public String getUpdatingCategory(Model model,
                                      @PathVariable Integer id) {
        model.addAttribute("category", categoryService.findById(id));
        return "dashboard/update-delete-category";
    }

    @RequireAdmin
    @RequestMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/dashboard/categories";
    }
}
