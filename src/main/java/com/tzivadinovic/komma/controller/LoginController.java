package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("dto", new RegisterDTO());
        return "register/register";
    }
}
