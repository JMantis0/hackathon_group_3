package com.revature.controllers;

import com.revature.entities.CharacterEntity;
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
    public CharacterEntity addCharacter(@RequestBody CharacterEntity characterEntity){
        return this.characterService.saveCharacter(characterEntity);
    }
}
