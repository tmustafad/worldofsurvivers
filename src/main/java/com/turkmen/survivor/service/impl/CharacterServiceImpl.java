package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.service.CharacterService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.config.GameEngine;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;
import com.turkmen.survivor.persistence.impl.PlanetContainerImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <h1>The service impl of Character </h1>
 *
 *
 * @see  @{@link CharacterService}
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */

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
                .values().stream().filter(f->f != null).collect(Collectors.toList());
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
                .filter(c -> c != null && c.getId() == sourceId).findFirst().get();
        Character character = planetContainerImpl.getPlanets().values().stream().filter(p -> p.getName().equalsIgnoreCase(planetName)).findFirst().get().getMatrix()[location];

        source =gameEngine.withdrawSearchingCost(source);
        update(source);
        if(character != null)
        update(character);
        return character != null ? character : null;
    }

    @Override
    public Character delete(Character character) throws ServiceException {
        return characterContainerImpl.delete(character);
    }
}
