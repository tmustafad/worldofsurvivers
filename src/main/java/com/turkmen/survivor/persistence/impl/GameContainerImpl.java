package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class GameContainerImpl implements Container<Game> {


    private static GameContainerImpl gameContainerImpl;

    Map<Integer, Game> games;

    {
        games = new HashMap<Integer, Game>();
    }

    private GameContainerImpl() {
        System.out.println("Game container initiated........");
    }

    public static GameContainerImpl getInstance() {
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


    public Map<Integer, Game> getGames() {
        return games;
    }
}
