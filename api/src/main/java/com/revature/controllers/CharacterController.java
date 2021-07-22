package com.revature.controllers;

import com.revature.entities.Character;
import com.revature.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("character")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @PostMapping("/add")
    public Character addCharacter(@RequestBody Character character){
        return this.characterService.saveCharacter(character);
    }
}
