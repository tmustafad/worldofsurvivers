package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.Planet;

import java.util.List;

public class PlanetEntity implements Planet {

    private int id;
    private List<Character> characters;
    private Character[][] matrix;
    private String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public List<Character> getCharacters() {
        return this.characters;
    }

    @Override
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public Character[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public void setMatrix(Character[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
