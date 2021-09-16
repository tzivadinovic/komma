package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/tags")
    public String getAllTags(Model model) {
        model.addAttribute("tags", tagService.findAll());
        return "";
    }
}
