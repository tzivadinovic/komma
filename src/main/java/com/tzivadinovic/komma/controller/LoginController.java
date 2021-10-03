package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("dto", new RegisterDTO());
        return "register/register";
    }

//    @GetMapping
//    public String login(Model model, HttpServletRequest request){
//        if(request.getParameter("error") != null){
//            model.addAttribute("error", "Wrong username or password");
//        }
//        return "index";
//    }

}
