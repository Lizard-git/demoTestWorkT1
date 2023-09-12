package com.example.demotestworkt1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CountCharactersObject {
    private String character;
    private short count;
}
