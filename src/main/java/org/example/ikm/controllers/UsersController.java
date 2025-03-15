package org.example.ikm.controllers;

import org.example.ikm.models.Users;
import org.example.ikm.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users/listUsers";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", usersService.findById(id).orElse(new Users()));
        return "users/formUsers";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "users/formUsers";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute Users user) {
        usersService.save(user);
        return "redirect:/users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.delete(id);
        return "redirect:/users/list";
    }
}