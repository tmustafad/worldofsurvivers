package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class CharacterContainerImpl implements Container<Character> {

    private static CharacterContainerImpl characterContainerImpl;
    Map<Integer, Character> characters;

    {
        characters = new HashMap<Integer, Character>();
    }

    private CharacterContainerImpl() {
        System.out.println("Character container initialized........");
    }

    public static CharacterContainerImpl getInstance() {
        if (characterContainerImpl == null) {
            characterContainerImpl=new CharacterContainerImpl();
        }
        return characterContainerImpl;
    }

    @Override
    public Map<Integer, Character> get() {
        return this.characters;
    }

    @Override
    public void add(Character character) {
        this.characters.put(character.getId(), character);
    }

    public Map<Integer, Character> getCharacters() {
        return characters;
    }
}
