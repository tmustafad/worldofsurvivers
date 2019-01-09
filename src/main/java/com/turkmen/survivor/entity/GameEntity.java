package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.CharacterType;
import com.turkmen.survivor.api.Game;

import java.util.List;

public class GameEntity implements Game {

    private List<Character> characters;

    @Override
    public Character findAndAttack(CharacterType characterType) {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
