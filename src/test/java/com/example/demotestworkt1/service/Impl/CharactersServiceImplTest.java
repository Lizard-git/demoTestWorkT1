package com.example.demotestworkt1.service.Impl;

import com.example.demotestworkt1.service.CharactersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CharactersServiceImplTest {
    private CharactersService charactersService;

    @BeforeEach
    void setUp() { charactersService = new CharactersServiceImpl();}

    @Test
    void getCountCharacters() {
        String textOne = "Hello World!";
        String textTwo = "";
        String textThree = null;

        Map<Character, Integer> countMap = charactersService.getCountCharacters(textOne);
        Assertions.assertEquals(9, countMap.size());
        Assertions.assertEquals(1, countMap.get('H'));
        Assertions.assertEquals(3, countMap.get('l'));
        Assertions.assertEquals(2, countMap.get('o'));
        Assertions.assertEquals(1, countMap.get(' '));
        Assertions.assertNull(countMap.get('z'));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacters(textTwo));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacters(textThree));
    }

    @Test
    void getCountCharacter() {
        String textOne = "Hello World!";
        String textTwo = "";
        String textThree = null;
        Assertions.assertEquals(3, charactersService.getCountCharacter(textOne, "l".charAt(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacter(textTwo, "l".charAt(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacter(textThree, "l".charAt(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacter(textTwo, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> charactersService.getCountCharacter(textThree, null));
    }
}