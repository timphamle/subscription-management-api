package com.timle.subscriptionapi.controller;

import com.timle.subscriptionapi.model.User;
import com.timle.subscriptionapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // requests
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void postUser(@RequestBody User user){
        userService.addUser(user);
    }
}