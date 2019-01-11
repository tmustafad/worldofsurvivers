package com.turkmen.survivor.api;

import java.util.List;

public interface Planet {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    Character[][] getMatrix();

    void setMatrix(Character[][] matrix);

    List<Character> getCharacters();

    void setCharacters(List<Character> characters);

}