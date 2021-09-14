package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public String getRoles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "roles/roles";
    }

}
