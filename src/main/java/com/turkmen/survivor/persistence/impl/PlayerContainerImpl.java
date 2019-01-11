package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.Player;
import com.turkmen.survivor.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class PlayerContainerImpl implements Container<Player> {
    private static PlayerContainerImpl playerContainerImpl = null;

    private Map<Integer, Player> players;

    {
        players = new HashMap<Integer, Player>();
    }

    private PlayerContainerImpl() {
        System.out.println("Player container initialized.....");
    }


    public static PlayerContainerImpl getPlayerContainerImpl() {
        if (playerContainerImpl == null) {
            return new PlayerContainerImpl();
        }
        return playerContainerImpl;
    }

    @Override
    public Map<Integer, Player> get() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        players.put(player.getId(), player);
    }
}
