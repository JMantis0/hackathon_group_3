package com.revature.controllers;

import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("user")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User saveUser(@RequestBody UserDTO userDTO)
    {
        System.out.println(userDTO);
        User user = new User(userDTO.getName(), userDTO.getEmail(), 0);
        System.out.println(user);
        return userService.saveUser(user);
    }

}
