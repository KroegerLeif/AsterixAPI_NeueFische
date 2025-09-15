package org.example.asterixapi_neuefische.controller;

import org.example.asterixapi_neuefische.repro.CharacterRepository;
import org.springframework.web.bind.annotation.*;
import org.example.asterixapi_neuefische.Character;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
public class AsterixController {
    private final CharacterRepository characterRepository;

    public AsterixController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters/all")
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @PostMapping("newCharacter")
    public Character newCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }

    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterRepository.deleteById(id);
    }

    @PutMapping("/characters/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character character) {
        Character oldCharacter = characterRepository.findById(id).orElse(null);
        if(oldCharacter != null){
            return characterRepository.save(oldCharacter
                    .withAge(character.age())
                    .withName(character.name())
                    .withProfession(character.profession()));
        }
        return character;
    }

//    @RequestMapping("/characters")
//    public List<Character> getCharacters() {
//        return List.of(
//                new Character("1", "Asterix", 35, "Warrior"),
//                new Character("2", "Obelix", 35, "Supplier"),
//                new Character("3", "Miraculix", 60, "Druid"),
//                new Character("4", "Majestix", 60, "Chief"),
//                new Character("5", "Troubadix", 25, "Bard"),
//                new Character("6", "Gutemine", 35, "Chiefs Wife"),
//                new Character("7", "Idefix", 5, "Dog"),
//                new Character("8", "Geriatrix", 70, "Retiree"),
//                new Character("9", "Automatix", 35, "Smith"),
//                new Character("10", "Grockelix", 35, "Fisherman")
//        );
//    }
}
