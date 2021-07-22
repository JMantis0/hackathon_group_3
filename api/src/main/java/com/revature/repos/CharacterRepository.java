package com.revature.repos;


import com.revature.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    List<CharacterEntity> findByUser_Id(int id);

}
