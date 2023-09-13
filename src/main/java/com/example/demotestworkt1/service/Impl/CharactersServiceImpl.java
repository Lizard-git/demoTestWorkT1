package com.example.demotestworkt1.service.Impl;

import com.example.demotestworkt1.service.CharactersService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharactersServiceImpl implements CharactersService {
    @Override
    public Map<Character, Integer> getCountCharacters(String text) {
        return countCharacters(text);
    }

    @Override
    public Integer getCountCharacter(String text, Character character) {
        return countCharacters(text).get(character);
    }

    //The method counts the number of occurrences of characters in the text
    private static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }
}
