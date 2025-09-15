package org.example.asterixapi_neuefische.service;

import org.example.asterixapi_neuefische.model.Character;
import org.example.asterixapi_neuefische.repro.CharacterRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public int getAverageAge(String profession) {
        List<Character> characters = characterRepository.findByProfession(profession);
        int sum = 0;
        for (Character character : characters) {
            sum += character.age();
        }
        return sum / characters.size();
    }

    public List<Character> getCharacterById(String id) {
        return characterRepository.findCharacterById(id);
    }

    public List<Character> getCharacterByName(String name) {
        return characterRepository.findByName(name);
    }

    public List<Character> getCharacterByProfession(String profession) {
        return characterRepository.findByProfession(profession);
    }

    public List<Character> getCharacterByAge(int age) {
        return characterRepository.findByAge(age);
    }

    public Character newCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }

    public Character updateCharacter(String id, Character character) {
        Character oldCharacter = characterRepository.findById(id).orElse(null);
        if(oldCharacter != null){
            return characterRepository.save(oldCharacter
                    .withAge(character.age())
                    .withName(character.name())
                    .withProfession(character.profession()));
        }
        return character;
    }
}
