package com.turkmen.survivor.ui;

import com.turkmen.survivor.api.model.Player;
import com.turkmen.survivor.api.service.PlayerService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entitydto.PlayerDto;
import com.turkmen.survivor.service.impl.PlayerServiceImpl;
import com.turkmen.survivor.ui.mapper.PlayerMapper;
import com.turkmen.survivor.util.Utils;

import java.util.List;
/**
 * <h1> The Player User Interaction class,a simulation of a controller. All manipulations are handled via service layer.</h1>
 *
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlayerUI {

    private PlayerService playerService = GenericBuilder.of(PlayerServiceImpl::new)
            .build();


    /**
     * @param name
     * @return PlayerDto
     */
    public Player create(String name) {
        PlayerDto dto = GenericBuilder.of(PlayerDto::new)
                .with(PlayerDto::setName, name)
                .with(PlayerDto::setId, Utils.generateRandomInt())
                .build();
        Player playerEntity = PlayerMapper.makePlayerEntity(dto);
        playerService.create(playerEntity);
        return dto;
    }

    public Player update(Player player){
        return playerService.update(player);
    }

    public List<Player> getAllPlayers() {
        return PlayerMapper.makePlayerDtoList(playerService.getAll());
    }
}
