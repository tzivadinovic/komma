package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/dashboard/tags")
    public String getTagsOnDashboard(Model model) {
        model.addAttribute("tags", tagService.findAll());
        return "dashboard/tags";
    }

//    @GetMapping("/home/new-post")
//    public String getAllTags(Model model) {
//        model.addAttribute("tags", tagService.findAll());
//        return "home/new-post";
//    }

    @PostMapping("/save-tag")
    public String saveTag(Model model, Tag tag) {
        model.addAttribute("tag", tagService.save(tag));
        return "redirect:/dashboard";
    }
}
