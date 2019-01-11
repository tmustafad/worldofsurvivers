package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlayerEntity;
import com.turkmen.survivor.entitydto.PlayerDto;

public class PlayerMapper {


    public static PlayerEntity makePlayerEntity(PlayerDto playerDto) {
        return GenericBuilder.of(PlayerEntity::new)
                .with(PlayerEntity::setId, playerDto.getId())
                .with(PlayerEntity::setGameId, playerDto.getId())
                .with(PlayerEntity::setName, playerDto.getName())
                .with(PlayerEntity::setScore, playerDto.getScore())
                .build();
    }


    public static PlayerDto makePlayerDto(PlayerEntity playerEntity) {
        return GenericBuilder.of(PlayerDto::new)
                .with(PlayerDto::setId, playerEntity.getId())
                .with(PlayerDto::setGameId, playerEntity.getGameId())
                .with(PlayerDto::setName, playerEntity.getName())
                .with(PlayerDto::setScore, playerEntity.getScore())
                .build();
    }
}
