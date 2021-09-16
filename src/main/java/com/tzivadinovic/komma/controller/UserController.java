package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.UserService;
import com.tzivadinovic.komma.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/createUser")
    public String createUser(@Validated User user, BindingResult result){
        if(result.hasErrors()) return "";
        userService.save(user);
        return "redirect:/";
    }
}
