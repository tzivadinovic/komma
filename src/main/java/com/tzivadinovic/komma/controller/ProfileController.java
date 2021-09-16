package com.tzivadinovic.komma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    @RequestMapping("/profile")
    public String profile() {
        return "home/profile";
    }
}
