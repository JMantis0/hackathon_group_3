package com.revature.controllers;

import com.revature.dtos.CharacterDTO;
import com.revature.entities.CharacterEntity;
import com.revature.services.CharacterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CharacterController
{
    private CharacterService characterService;

    public CharacterController(CharacterService characterService)
    {
        this.characterService = characterService;
    }

    @PostMapping(produces = "application/json")
    public CharacterEntity saveCharacter(@RequestBody CharacterDTO characterDTO)
    {
        System.out.println(characterDTO);
        CharacterEntity character = new CharacterEntity(characterDTO.getName(), characterDTO.getEmail(), 0);
        System.out.println(character);
        return characterService.saveCharacter(character);
    }
}
