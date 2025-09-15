package org.example.asterixapi_neuefische.repro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.example.asterixapi_neuefische.Character;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
    Character findByName(String name);
}
