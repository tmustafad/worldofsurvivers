package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>The  DB simulation, a hashmap is used for keeping the data throught game lifecycle. </h1>
 *
 * When a game starts a singelton container impl for every entity is created
 *
 * @see  Container
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */

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
            characterContainerImpl = new CharacterContainerImpl();
        }
        return characterContainerImpl;
    }

    @Override
    public Map<Integer, Character> get() {
        return this.characters;
    }

    @Override
    public Character add(Character character) {
        if (this.characters.containsKey(character.getId())) {
            this.characters.replace(character.getId(), characters.get(character.getId()), character);
            return this.characters.get(character.getId());
        }
        return this.characters.put(character.getId(), character);
    }

    @Override
    public Character delete(Character character) {
        if (this.characters.containsKey(character.getId())) {
            this.characters.replace(character.getId(), characters.get(character.getId()), null);
            return this.characters.get(character.getId());
        }
        return this.characters.put(character.getId(), character);
    }

    public Map<Integer, Character> getCharacters() {
        return characters;
    }


}
