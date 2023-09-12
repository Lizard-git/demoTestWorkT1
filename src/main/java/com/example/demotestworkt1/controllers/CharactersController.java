package com.example.demotestworkt1.controllers;

import com.example.demotestworkt1.model.CountCharactersObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CharactersController {

    @PostMapping("/string/characters/get/count")
    public ResponseEntity<List<CountCharactersObject>> getCountCharacters(@RequestParam(value = "text") String text) {
        CountCharactersObject objectOne = CountCharactersObject.builder().character("a").count((short) 2).build();
        CountCharactersObject objectTwo = CountCharactersObject.builder().character("a").count((short) 4).build();
        List<CountCharactersObject> result = new ArrayList<>();
        result.add(objectOne);
        result.add(objectTwo);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/string/characters/get/count/{characters}")
    public ResponseEntity<CountCharactersObject> getCountCharacter(@PathVariable String characters) {
        CountCharactersObject result = CountCharactersObject.builder().character(characters).count((short) 5).build();
        return ResponseEntity.ok(result);
    }
}
