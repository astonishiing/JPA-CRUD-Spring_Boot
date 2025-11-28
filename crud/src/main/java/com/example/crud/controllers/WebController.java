package com.example.crud.controllers;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/users")
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUser());
        return "index";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {

        if (user.getUserId() == null) {
            userService.createUser(new CreateUserDto(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            ));

        } else {
            userService.updateUserById(
                    user.getUserId().toString(),
                    new UpdateUserDto(
                            user.getUsername(),
                            user.getPassword()
                    )
            );
        }

        return "redirect:/ui/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable UUID id, Model model) {
        var user = userService.getUserById(id.toString());

        if (user.isEmpty()) {
            return "redirect:/ui/users";
        }

        model.addAttribute("user", user.get());
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteById(id.toString());
        return "redirect:/ui/users";
    }
}
