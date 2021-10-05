package com.tzivadinovic.komma.controller;

import com.tzivadinovic.komma.domain.RecordStatus;
import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.ChangePasswordDTO;
import com.tzivadinovic.komma.entity.dto.RegisterDTO;
import com.tzivadinovic.komma.repository.UserRepository;
import com.tzivadinovic.komma.service.RoleService;
import com.tzivadinovic.komma.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/dashboard/users")
    public String getUsersOnDashboard(Model model,
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
        model.addAttribute("dashUsers", userService.findAll(PageRequest.of(pageNumber, sizeCount)));
        return "dashboard/users";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute("dto") @Valid RegisterDTO dto, BindingResult result) {
        if (result.hasErrors()) return "register/register";
        userService.save(dto);
        return "redirect:/";
    }

    @GetMapping("/user/{username}")
    public String findUserByUsername(Model model, @PathVariable String username) {
        model.addAttribute("user", userRepository.findByUsername(username));
        return "home/profile";
    }

    @PostMapping("/update-password")
    public String updatePassword(@AuthenticationPrincipal User user,
                                 @ModelAttribute ChangePasswordDTO dto,
                                 Model model) {
        model.addAttribute("", userService.changeUserPassword(user, dto));
        return "redirect:/";
    }

    //TODO osmisliti kako da se samo odredjena polja menjaju iako ima vise atributa
    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("", userService.update(user));
        return "redirect:/dashboard/users";
    }

    @GetMapping("/users/{id}")
    public String getUpdatingUser(Model model,
                                  @PathVariable Integer id) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.findAll());
        return "dashboard/update-delete-user";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteById(user.getId());
        return "redirect:/dashboard/users";
    }

    @RequestMapping("/create-user-page")
    public String userPage(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "dashboard/create-user";
    }

    @PostMapping("/create-user-as-admin")
    public String createUserAsAdmin(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/dashboard/users";
    }
}
