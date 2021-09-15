package com.tzivadinovic.komma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @RequestMapping("/register")
    public String register() {
        return "register/register";
    }
}
