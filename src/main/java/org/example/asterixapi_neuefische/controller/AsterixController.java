package org.example.asterixapi_neuefische.controller;

import org.example.asterixapi_neuefische.dto.RegisterCharacterDTO;
import org.example.asterixapi_neuefische.service.CharacterService;
import org.springframework.web.bind.annotation.*;
import org.example.asterixapi_neuefische.model.Character;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
public class AsterixController {
    private final CharacterService characterService;

    //Constructor
    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }


    //Get Mapping
    @GetMapping("/characters/all")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/characters/avgAge{profession}")
    public int getAverageAge(@PathVariable String profession) {
        return characterService.getAverageAge(profession);
    }

    @GetMapping("/characters/{id}")
    public List<Character> getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping("/characters/{name}")
    public List<Character> getCharacterByName(@PathVariable String name) {
        return characterService.getCharacterByName(name);
    }

    @GetMapping("/characters/{profession}")
    public List<Character> getCharacterByProfession(@PathVariable String profession) {
        return characterService.getCharacterByProfession(profession);
    }

    @GetMapping("/characters/{age}")
    public List<Character> getCharacterByAge(@PathVariable int age) {
        return characterService.getCharacterByAge(age);
    }

    //Post Mapping
    @PostMapping("newCharacter")
    public Character newCharacter(@RequestBody RegisterCharacterDTO newCharacter) {
        return characterService.newCharacter(newCharacter);
    }

    //Delete Mapping
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterService.deleteCharacter(id);
    }

    //Put Mapping
    @PutMapping("/characters/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character character) {
        return characterService.updateCharacter(id, character);
    }

}
