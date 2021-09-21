package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update-tag")
    public String updateTag(@ModelAttribute("tag") Tag tag) {
        tagService.save(tag);
        return "redirect:/dashboard/tags";
    }

    @GetMapping("/tag/{id}")
    public String getUpdatingTag(Model model,
                                 @PathVariable Integer id) {
        model.addAttribute("tag", tagService.findById(id));
        return "dashboard/update-delete-tag";
    }

    @PostMapping("/tag/delete")
    public String deleteTag(@ModelAttribute("tag") Tag tag) {
        tagService.deleteById(tag.getId());
        return "redirect:/dashboard/tags";
    }

}
