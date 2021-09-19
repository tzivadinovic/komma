package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/dashboard/tags")
    public String getTagsOnDashboard(Model model,
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
        model.addAttribute("dashTags", tagService.findAll(PageRequest.of(pageNumber, sizeCount)));
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

    @PostMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable("id") Integer id, Model model) {
        tagService.deleteById(id);
        return "redirect:/dashboard/tags";
    }

}
