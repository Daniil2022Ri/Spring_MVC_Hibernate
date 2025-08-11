package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String email) {
        userService.createUser(name, email);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id,
                         @RequestParam String name,
                         @RequestParam String email) {
        userService.updateUser(id, name, email);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
