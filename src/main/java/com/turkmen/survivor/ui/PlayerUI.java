package com.turkmen.survivor.ui;

import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlayerEntity;
import com.turkmen.survivor.entitydto.PlayerDto;
import com.turkmen.survivor.service.PlayerService;
import com.turkmen.survivor.service.impl.PlayerServiceImpl;
import com.turkmen.survivor.ui.mapper.PlayerMapper;
import com.turkmen.survivor.util.Utils;

public class PlayerUI {
    private PlayerService playerService = GenericBuilder.of(PlayerServiceImpl::new)
            .build();


    /**
     * @param name
     * @return PlayerDto
     * @TODO casting will be fixed structurelly
     */
    public PlayerDto create(String name) {
        PlayerEntity playerEntity = PlayerMapper.makePlayerEntity(GenericBuilder.of(PlayerDto::new)
                .with(PlayerDto::setName, name)
                .with(PlayerDto::setId, Utils.generateRandomInt())
                .build());
        return PlayerMapper.makePlayerDto((PlayerEntity) playerService.create(playerEntity));
    }
}
