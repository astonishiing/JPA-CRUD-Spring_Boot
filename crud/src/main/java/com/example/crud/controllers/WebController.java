package com.example.crud.controllers;

import com.example.crud.entity.User;
import com.example.crud.service.UserWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/ui/users")
public class WebController{
    private final UserWebService userWebService;

    public WebController(UserWebService userWebService){
        this.userWebService = userWebService;
    }

    @GetMapping
    public String listUsers(Model model){
        model.addAttribute("users", userWebService.getAll());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user){
        userWebService.save(user);
        return "redirect:/ui/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable UUID id, Model model){
        model.addAttribute("users", userWebService.getById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id){
        userWebService.delete(id);
        return "redirect://users";
    }

}
