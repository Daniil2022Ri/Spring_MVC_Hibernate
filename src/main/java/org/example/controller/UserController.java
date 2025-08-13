package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {


    private final UserService userService;


    public UserController( UserService userService){
        this.userService = userService;
    }

    @GetMapping({"/","/users"})
    public String listUsers(Map<String , Object> map){
        map.put("user" , new User());
        map.put("usersList" , userService.listUser());

        return "users";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/users";
    }

    @RequestMapping(value ="/add" , method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user , BindingResult result){
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userid) {

        userService.removeUser(userid);

        return "redirect:/users";
    }
}
