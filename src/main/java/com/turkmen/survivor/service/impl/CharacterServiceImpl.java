package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.service.CharacterService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.config.GameEngine;
import com.turkmen.survivor.config.GameState;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;
import com.turkmen.survivor.persistence.impl.PlanetContainerImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterServiceImpl implements CharacterService {

    GameEngine gameEngine = GenericBuilder.of(GameEngine::new).build();
    CharacterContainerImpl characterContainerImpl = CharacterContainerImpl.getInstance();
    PlanetContainerImpl planetContainerImpl = PlanetContainerImpl.getInstance();

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
    public Character get(String name) {
        return null;
    }

    @Override
    public Character update(Character character) {
        return characterContainerImpl.add(character);
    }

    @Override
    public Character attack(Character attacker, int targetId) {
        Character target = characterContainerImpl.getCharacters().get(targetId);
        Character result = gameEngine.attack(attacker, target);
        characterContainerImpl.add(attacker);
        return attacker;
    }

    @Override
    public Character find(String planetName, int sourceId, int location) {
        Character source = Arrays.stream(planetContainerImpl.getPlanets().values().stream().filter(p -> p.getName().equalsIgnoreCase(planetName)).findFirst().get().getMatrix())
                .filter(c -> c.getId() == sourceId).findFirst().get();
        Character character = planetContainerImpl.getPlanets().values().stream().filter(p -> p.getName().equalsIgnoreCase(planetName)).findFirst().get().getMatrix()[location];

        gameEngine.withdrawSearchingCost(source);
        update(source);
        update(character);
        return character != null ? character : null;
    }


}
