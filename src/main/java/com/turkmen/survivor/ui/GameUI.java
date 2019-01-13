package com.turkmen.survivor.ui;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.api.service.GameService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entitydto.GameDto;
import com.turkmen.survivor.service.impl.GameServiceImpl;
import com.turkmen.survivor.ui.mapper.GameMapper;
import com.turkmen.survivor.util.Utils;

import java.util.List;

public class GameUI {

    GameService gameService = GenericBuilder.of(GameServiceImpl::new).build();

    public GameDto create() {
        GameDto dto = GenericBuilder.of(GameDto::new)
                .with(GameDto::setId, Utils.generateRandomInt())
                .with(GameDto::setPlanet, null)
                .with(GameDto::setPlayer, null)
                .with(GameDto::setActive, Boolean.FALSE)
                .build();
        Game gameEntity = GameMapper.makeGameEntity(dto);
        gameService.create(gameEntity);
        return dto;
    }

    public GameDto update(Game game) {
        return GameMapper.makeGameDto(  gameService.update(game));
    }

    public List<Game> getAllGames() {
        return GameMapper.makeGameDtoList(gameService.getAll());
    }
}
