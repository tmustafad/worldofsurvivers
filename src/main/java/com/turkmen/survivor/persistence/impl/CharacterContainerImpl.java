package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class CharacterContainerImpl implements Container<Character> {

    private static CharacterContainerImpl characterContainerImpl = null;
    Map<Integer, Character> characters;

    {
        characters = new HashMap<Integer, Character>();
    }

    private CharacterContainerImpl() {
        System.out.println("Character container initialized........");
    }

    public static CharacterContainerImpl getcharacterContainerImpl() {
        if (characterContainerImpl == null) {
            return new CharacterContainerImpl();
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
}
