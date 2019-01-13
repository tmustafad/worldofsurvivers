package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Player;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class PlayerContainerImpl implements Container<Player> {
    private static PlayerContainerImpl playerContainerImpl;


    private Map<Integer, Player> players;

    {
        players = new HashMap<Integer, Player>();
    }

    private PlayerContainerImpl() {
        System.out.println("Player container initialized.....");
    }


    public static PlayerContainerImpl getInstance() {
        if (playerContainerImpl == null) {
            playerContainerImpl = new PlayerContainerImpl();
        }
        return playerContainerImpl;
    }

    @Override
    public Map<Integer, Player> get() {
        return this.players;
    }

    @Override
    public Player add(Player player) {
        if (this.players.containsKey(player.getId())) {
            this.players.replace(player.getId(), players.get(player.getId()), player);
            return this.players.get(player.getId());
        }
        return players.put(player.getId(), player);
    }


    @Override
    public Player delete(Player player) {
        if (this.players.containsKey(player.getId())) {
            this.players.replace(player.getId(), players.get(player.getId()), null);
            return this.players.get(player.getId());
        }
        return players.put(player.getId(), player);
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }
}
