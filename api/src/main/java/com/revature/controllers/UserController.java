package com.revature.controllers;

import com.revature.entities.User;
import com.revature.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController
{
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public User getUser(@RequestParam int id)
    {
        logger.info("UserController getUser before service: {}",id);
        Optional<User> user = userService.findById(id);
        logger.info("UserController getUser: {}",user.get());
        return user.get();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }
}
