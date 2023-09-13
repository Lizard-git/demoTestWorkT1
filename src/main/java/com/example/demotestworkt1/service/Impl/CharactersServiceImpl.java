package com.example.demotestworkt1.service.Impl;

import com.example.demotestworkt1.service.CharactersService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharactersServiceImpl implements CharactersService {
    @Override
    public Map<Character, Integer> getCountCharacters(String text) {
        if (ObjectUtils.isEmpty(text)) {
            throw new IllegalArgumentException("Parameter cannot be null or empty");
        }
        return countCharacters(text);
    }

    @Override
    public Integer getCountCharacter(String text, Character character) {
        if (ObjectUtils.isEmpty(text) || ObjectUtils.isEmpty(character)) {
            throw new IllegalArgumentException("Parameter cannot be null or empty");
        }
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
