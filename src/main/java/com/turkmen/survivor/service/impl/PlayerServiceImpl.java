package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.Player;
import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.persistence.impl.PlayerContainerImpl;
import com.turkmen.survivor.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
    PlayerContainerImpl playerContainerImpl = PlayerContainerImpl.getPlayerContainerImpl();

    @Override
    public Player create(Player player) throws ServiceException {
        playerContainerImpl.add(player);
        return player;
    }
}
