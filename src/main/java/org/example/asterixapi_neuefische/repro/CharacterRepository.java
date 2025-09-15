package org.example.asterixapi_neuefische.repro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.example.asterixapi_neuefische.model.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
    List<Character> findByName(String name);
    List<Character> findByProfession(String profession);
    List<Character> findByAge(int age);
    List<Character> findCharacterById(String id);
}
