package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.GameEntity;
import com.turkmen.survivor.entitydto.GameDto;

import java.util.List;
import java.util.stream.Collectors;

public class GameMapper {

    public static Game makeGameEntity(GameDto gameDto) {
        return GenericBuilder.of(GameEntity::new)
                .with(GameEntity::setId, gameDto.getId())
                .with(GameEntity::setPlanet, gameDto.getPlanet())
                .with(GameEntity::setPlayer, gameDto.getPlayer())
                .with(GameEntity::setActive,gameDto.isActive())
                .with(GameEntity::setName,gameDto.getName())
                .build();
    }


    public static Game makeGameDto(GameEntity gameEntity) {
        return GenericBuilder.of(GameDto::new)
                .with(GameDto::setId, gameEntity.getId())
                .with(GameDto::setPlanet, gameEntity.getPlanet())
                .with(GameDto::setPlayer, gameEntity.getPlayer())
                .with(GameDto::setActive,gameEntity.isActive())
                .with(GameDto::setName,gameEntity.getName())
                .build();
    }


    public static List<Game> makeGameDtoList(List<Game> games) {
        return games.stream().map(c -> GenericBuilder.of(GameDto::new)
                .with(GameDto::setId, c.getId())
                .with(GameDto::setPlanet, c.getPlanet())
                .with(GameDto::setPlayer, c.getPlayer())
                .with(GameDto::setActive,c.isActive())
                .with(GameDto::setName,c.getName())
                .build()).collect(Collectors.toList());
    }
}
