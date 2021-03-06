package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>The  DB simulation, a hashmap is used for keeping the data throught game lifecycle. </h1>
 *
 * When a game starts a singelton container impl for every entity is created
 *
 * @see  Container
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */

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

    @Override
    public Game delete(Game game) {
        if (this.games.containsKey(game.getId())) {
            this.games.replace(game.getId(), games.get(game.getId()), null);
            return this.games.get(game.getId());
        }



        return this.games.put(game.getId(), game);
    }

    public Game add(Game game) {
        if (this.games.containsKey(game.getId())) {
            this.games.replace(game.getId(), games.get(game.getId()), game);
            return this.games.get(game.getId());
        }



        return this.games.put(game.getId(), game);
    }


    public Map<Integer, Game> getGames() {
        return games;
    }
}
