package com.revature.controllers;

import com.revature.entities.Character;
import com.revature.services.CharacterService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("character")
public class CharacterController {
    private final CharacterService characterService;
    private final UserService userService;
    @Autowired
    public CharacterController(CharacterService characterService, UserService userService){
        this.characterService = characterService;
        this.userService = userService;
    }

    @PostMapping("/add/{id}")
    public Character addCharacter(@RequestBody Character character, @PathVariable int id){

        character.setUser(userService.findById(id).get());
        return characterService.saveCharacter(character);
    }

    @GetMapping("/user/{id}")
    public List<Character> findByUserId(@PathVariable int id){
        return characterService.findByUserId(id);
    }
}
