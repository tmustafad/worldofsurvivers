package com.turkmen.survivor.ui;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.CharacterType;
import com.turkmen.survivor.api.service.CharacterService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entitydto.CharacterDto;
import com.turkmen.survivor.service.impl.CharacterServiceImpl;
import com.turkmen.survivor.ui.mapper.CharacterMapper;
import com.turkmen.survivor.util.Utils;

import java.util.List;

/**
 * <h1> The Character User Interaction class,a simulation of a controller. All manipulations are handled via service layer.</h1>
 *
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class CharacterUI {

    CharacterService characterService = GenericBuilder.of(CharacterServiceImpl::new)
            .build();


    public CharacterDto create(String name, int health, boolean alive, CharacterType type, int planetId, int location) {

        CharacterDto dto = GenericBuilder.of(CharacterDto::new)
                .with(CharacterDto::setId, Utils.generateRandomInt())
                .with(CharacterDto::setAlive, alive)
                .with(CharacterDto::setHealth, health)
                .with(CharacterDto::setLocation, location)
                .with(CharacterDto::setName, name)
                .with(CharacterDto::setPlanetId, planetId)
                .with(CharacterDto::setType, type).build();
        Character characterEntity = CharacterMapper.makeCharacterEntity(dto);
        characterService.create(characterEntity);
        return dto;

    }

    public CharacterDto update(Character character) {
        return CharacterMapper.makeCharacterDto(characterService.update(character));
    }

    public List<Character> getAllCharacters() {
        return CharacterMapper.makeCharacterDtoList(characterService.getAll());
    }

    public CharacterDto find(String planetName, int sourceId, int location) {
        Character character=characterService.find(planetName, sourceId, location);
        if(character!= null)
        return CharacterMapper.makeCharacterDto(character);
        else
            return null;
    }

    public void delete(Character character){
        characterService.delete(character);
    }

    public Character attack(Character attacker, int targetId) {
        characterService.attack(attacker, targetId);
        return attacker;
    }


}
