package com.revature.services;

import com.revature.entities.CharacterEntity;
import com.revature.repos.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService
{
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository)
    {
        this.characterRepository = characterRepository;
    }

    public CharacterEntity saveCharacter(CharacterEntity character)
    {
        return characterRepository.save(character);
    }
}
