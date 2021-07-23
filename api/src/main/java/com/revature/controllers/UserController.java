package com.revature.controllers;

import com.revature.entities.CharacterEntity;
import com.revature.services.CharacterService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    public CharacterEntity addCharacter(@RequestBody CharacterEntity characterEntity) {
        return this.characterService.saveCharacter(characterEntity);
    }

    @GetMapping("/user/{id}")
    public List<CharacterEntity> findByUserId(@PathVariable int id){
        return characterService.findByUserId(id);
    }
}
