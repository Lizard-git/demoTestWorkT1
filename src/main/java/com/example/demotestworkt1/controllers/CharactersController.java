package com.example.demotestworkt1.controllers;

import com.example.demotestworkt1.service.CharactersService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class CharactersController {

    private final CharactersService charactersService;

    @PostMapping("/string/get/count/characters")
    public ResponseEntity<Map<Character, Integer>> getCountCharacters(
            @RequestParam(value = "text")
            @NotBlank(message = "Must not be empty")
            @Size(max = 5000,message = "The text is very large")
            String text
    ) {
        return ResponseEntity.ok(charactersService.getCountCharacters(text));
    }

    @PostMapping("/string/get/count/character")
    public ResponseEntity<Map<Character, Integer>> getCountCharacter(
            @RequestParam(value = "text")
            @NotBlank(message = "Must not be empty")
            @Size(max = 5000,message = "The text is very large")
            String text,
            @RequestParam("character") Character characters
    ) {
        Map<Character, Integer> result = new HashMap<>();
        result.put(characters, charactersService.getCountCharacter(text, characters));
        return ResponseEntity.ok(result);
    }
}
