package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.repository.UserRepository;
import com.tzivadinovic.komma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/createUser")
    public String createUser(@Validated User user, BindingResult result) {
        if (result.hasErrors()) return "";
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/{username}")
    public String findUserByUsername(Model model, @PathVariable String username) {
        model.addAttribute("user", userRepository.findByUsername(username));
        return "home/profile";
    }
}
