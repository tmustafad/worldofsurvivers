package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.Game;
import com.turkmen.survivor.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class GameContainerImpl implements Container<Game> {


    private static GameContainerImpl gameContainerImpl = null;

    Map<Integer, Game> games;

    {
        games = new HashMap<Integer, Game>();
    }

    private GameContainerImpl() {
        System.out.println("Game container initiated........");
    }

    public static GameContainerImpl getGameContainerImpl() {
        if (gameContainerImpl == null) {
            gameContainerImpl = new GameContainerImpl();
        }
        return gameContainerImpl;
    }

    public Map<Integer, Game> get() {
        return this.games;
    }

    public void add(Game game) {
        this.games.put(game.getId(),game);
    }
}
