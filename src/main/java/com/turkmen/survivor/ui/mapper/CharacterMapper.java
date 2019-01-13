package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.CharacterEntity;
import com.turkmen.survivor.entitydto.CharacterDto;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterMapper {


    public static CharacterEntity makeCharacterEntity(CharacterDto characterDto) {
        return GenericBuilder.of(CharacterEntity::new)
                .with(CharacterEntity::setId, characterDto.getId())
                .with(CharacterEntity::setLocation, characterDto.getLocation())
                .with(CharacterEntity::setPlanetId, characterDto.getPlanetId())
                .with(CharacterEntity::setAlive, characterDto.isAlive())
                .with(CharacterEntity::setHealth, characterDto.getHealth())
                .with(CharacterEntity::setName, characterDto.getName())
                .with(CharacterEntity::setType, characterDto.getType())
                .build();
    }


    public static CharacterDto makeCharacterDto(Character characterEntity) {
        return GenericBuilder.of(CharacterDto::new)
                .with(CharacterDto::setId, characterEntity.getId())
                .with(CharacterDto::setLocation, characterEntity.getLocation())
                .with(CharacterDto::setPlanetId, characterEntity.getPlanetId())
                .with(CharacterDto::setAlive, characterEntity.isAlive())
                .with(CharacterDto::setHealth, characterEntity.getHealth())
                .with(CharacterDto::setName, characterEntity.getName())
                .with(CharacterDto::setType, characterEntity.getType())
                .build();
    }


    public static List<Character> makeCharacterDtoList(List<Character> characters) {
        return characters.stream().map(c -> GenericBuilder.of(CharacterDto::new)
                .with(CharacterDto::setId, c.getId())
                .with(CharacterDto::setLocation, c.getLocation())
                .with(CharacterDto::setPlanetId, c.getPlanetId())
                .with(CharacterDto::setAlive, c.isAlive())
                .with(CharacterDto::setHealth, c.getHealth())
                .with(CharacterDto::setName, c.getName())
                .with(CharacterDto::setType, c.getType())
                .build()).collect(Collectors.toList());
    }
}
