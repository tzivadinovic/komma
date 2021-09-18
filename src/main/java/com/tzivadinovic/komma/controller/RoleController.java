package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.entity.Role;
import com.tzivadinovic.komma.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/dashboard/roles")
    public String getRolesOnDashboard(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "dashboard/roles";
    }

    @GetMapping("/roles")
    public String getRoles(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "roles/roles";
    }

    @PostMapping("/save-role")
    public String saveRole(Model model, Role newRole) {
        model.addAttribute("newRole", roleService.save(newRole));
        return "redirect:/dashboard";
    }

}
