package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.GameEntity;
import com.turkmen.survivor.entitydto.GameDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1> The Game mapper between Entity and DTOs</h1>
 *
 *
 * @see  @{@link com.turkmen.survivor.ui.GameUI}
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class GameMapper {

    public static GameEntity makeGameEntity(Game gameDto) {
        return GenericBuilder.of(GameEntity::new)
                .with(GameEntity::setId, gameDto.getId())
                .with(GameEntity::setPlanet, gameDto.getPlanet())
                .with(GameEntity::setPlayer, gameDto.getPlayer())
                .with(GameEntity::setActive,gameDto.isActive())
                .with(GameEntity::setName,gameDto.getName())
                .with(GameEntity::setStatus,gameDto.getStatus())
                .build();
    }


    public static GameDto makeGameDto(Game gameEntity) {
        return GenericBuilder.of(GameDto::new)
                .with(GameDto::setId, gameEntity.getId())
                .with(GameDto::setPlanet, gameEntity.getPlanet())
                .with(GameDto::setPlayer, gameEntity.getPlayer())
                .with(GameDto::setActive,gameEntity.isActive())
                .with(GameDto::setName,gameEntity.getName())
                .with(GameDto::setStatus,gameEntity.getStatus())
                .build();
    }


    public static List<Game> makeGameDtoList(List<Game> games) {
        return games.stream().map(c -> GenericBuilder.of(GameDto::new)
                .with(GameDto::setId, c.getId())
                .with(GameDto::setPlanet, c.getPlanet())
                .with(GameDto::setPlayer, c.getPlayer())
                .with(GameDto::setActive,c.isActive())
                .with(GameDto::setName,c.getName())
                .with(GameDto::setStatus,c.getStatus())
                .build()).collect(Collectors.toList());
    }
}
