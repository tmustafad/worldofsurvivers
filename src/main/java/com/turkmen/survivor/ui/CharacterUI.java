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

public class CharacterUI {

    CharacterService characterService = GenericBuilder.of(CharacterServiceImpl::new)
            .build();


    public Character create(String name, int health, boolean alive, CharacterType type, int planetId, int location) {

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


    public List<Character> getAllCharacters() {
        return CharacterMapper.makeCharacterDtoList(characterService.getAll());
    }
}
