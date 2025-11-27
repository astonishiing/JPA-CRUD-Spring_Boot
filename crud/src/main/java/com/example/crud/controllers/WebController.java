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

    // LISTAR USUÁRIOS
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUser());
        return "index"; // templates/index.html
    }

    // FORM PARA CRIAR USUÁRIO
    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User()); // objeto vazio
        return "form"; // templates/form.html
    }

    // SALVAR (CRIAR OU EDITAR)
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {

        if (user.getUserId() == null) {
            // criação — converte entidade para CreateUserDto
            userService.createUser(new CreateUserDto(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword()
            ));

        } else {
            // edição — converte entidade para UpdateUserDto
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

    // FORM DE EDIÇÃO
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable UUID id, Model model) {
        var user = userService.getUserById(id.toString());

        if (user.isEmpty()) {
            return "redirect:/ui/users";
        }

        model.addAttribute("user", user.get());
        return "form";
    }

    // EXCLUIR
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteById(id.toString());
        return "redirect:/ui/users";
    }
}
