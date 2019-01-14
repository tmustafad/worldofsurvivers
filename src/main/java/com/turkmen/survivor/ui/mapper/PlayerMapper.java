package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.api.model.Player;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlayerEntity;
import com.turkmen.survivor.entitydto.PlayerDto;

import java.util.List;
import java.util.stream.Collectors;


/**
 * <h1> The Character mapper between Entity and DTOs</h1>
 *
 *
 * @see  @{@link com.turkmen.survivor.ui.PlayerUI}
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlayerMapper {


    public static Player makePlayerEntity(PlayerDto playerDto) {
        return GenericBuilder.of(PlayerEntity::new)
                .with(PlayerEntity::setId, playerDto.getId())
                .with(PlayerEntity::setGameId, playerDto.getGameId())
                .with(PlayerEntity::setName, playerDto.getName())
                .with(PlayerEntity::setScore, playerDto.getScore())
                .build();
    }


    public static Player makePlayerDto(Player playerEntity) {
        return GenericBuilder.of(PlayerDto::new)
                .with(PlayerDto::setId, playerEntity.getId())
                .with(PlayerDto::setGameId, playerEntity.getGameId())
                .with(PlayerDto::setName, playerEntity.getName())
                .with(PlayerDto::setScore, playerEntity.getScore())
                .build();
    }

    public static List<Player> makePlayerDtoList(List<Player> players) {
        return players.stream().map(p -> GenericBuilder.of(PlayerDto::new)
                .with(PlayerDto::setId, p.getId())
                .with(PlayerDto::setGameId, p.getGameId())
                .with(PlayerDto::setName, p.getName())
                .with(PlayerDto::setScore, p.getScore())
                .build()).collect(Collectors.toList());
    }
}
