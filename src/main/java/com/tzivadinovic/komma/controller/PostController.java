package com.tzivadinovic.komma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    @RequestMapping("/new-post")
    public String register() {
        return "home/new-post";
    }
}
