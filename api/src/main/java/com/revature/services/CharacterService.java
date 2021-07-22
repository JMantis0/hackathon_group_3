package com.revature.services;

import com.revature.entities.CharacterEntity;
import com.revature.repos.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }
    public CharacterEntity saveCharacter(CharacterEntity characterEntity){
        return characterRepository.save(characterEntity);
    }
    public List<CharacterEntity> findByUserId(int id){
        return characterRepository.findByUser_Id(id);
    }
}
