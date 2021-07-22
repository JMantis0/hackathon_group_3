package com.revature.controllers;

import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Controller
{
    private UserService userService;

    public Controller(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json")
    public User saveUser(@RequestBody UserDTO userDTO)
    {
        System.out.println(userDTO);
        User user = new User(userDTO.getName(), userDTO.getEmail(), 0);
        System.out.println(user);
        return userService.saveUser(user);
    }
}
