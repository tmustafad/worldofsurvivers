package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.model.Player;
import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.persistence.impl.PlayerContainerImpl;
import com.turkmen.survivor.api.service.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1>The service impl of Player </h1>
 *
 *
 * @see  @{@link PlayerService}
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlayerServiceImpl implements PlayerService {
    PlayerContainerImpl playerContainerImpl = PlayerContainerImpl.getInstance();

    @Override
    public Player create(Player player) throws ServiceException {
        playerContainerImpl.add(player);
        return player;
    }

    @Override
    public List<Player > getAll() throws ServiceException {
        return playerContainerImpl.getPlayers()
                .values().stream().collect(Collectors.toList());
    }

    @Override
    public Player get(String name) {
        return playerContainerImpl.getPlayers().values()
                .stream().filter(p->p.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public Player update(Player player) {
        return playerContainerImpl.add(player);
    }
}
