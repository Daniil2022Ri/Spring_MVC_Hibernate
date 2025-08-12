package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public String listUsers(Map<String , Object> map){
        map.put("user" , new User());
        map.put("usersList" , userService.listUser());

        return "user";
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

        userService.remove(userid);

        return "redirect:/index";
    }
}
