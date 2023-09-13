package com.example.demotestworkt1.service;

import java.util.Map;

public interface CharactersService {
    /**
     * This method gets the count of all characters in the text
     * @param text text in which we want to count the number of each character
     * @return Number of occurrences of characters in the text in the form of a map:
     * key - symbol, value - count (Map<Character, Integer>)
     */
    Map<Character, Integer> getCountCharacters(String text);

    /**
     * This method gets the number of occurrences of one character in the text
     * @param text text in which we want to count the number of each character
     * @param character symbol whose quantity we want to know
     * @return Number of occurrences of a character in the text (Integer)
     */
    Integer getCountCharacter(String text, Character character);
}
