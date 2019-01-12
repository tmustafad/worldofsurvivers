package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.service.CharacterService;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterServiceImpl implements CharacterService {

    CharacterContainerImpl characterContainerImpl = CharacterContainerImpl.getInstance();

    @Override
    public Character create(Character character) throws ServiceException {
        characterContainerImpl.add(character);
        return character;
    }

    @Override
    public List<Character> getAll() throws ServiceException {
        return characterContainerImpl.getCharacters()
                .values().stream().collect(Collectors.toList());
    }


    @Override
    public void attack(Character attacker, int targetId) {
        Character target = characterContainerImpl.getCharacters().get(targetId);
        attacker.setHealth(attacker.getHealth() > target.getHealth() ? attacker.getHealth() + target.getHealth() : attacker.getHealth() - target.getHealth());
        characterContainerImpl.getCharacters().put(attacker.getId(), attacker);
    }

    @Override
    public Character get(String name) {
        return null;
    }

    @Override
    public Character update(Character character) {
        return characterContainerImpl.getCharacters().put(character.getId(),character);
    }
}
