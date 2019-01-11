package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.Game;
import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.persistence.impl.GameContainerImpl;
import com.turkmen.survivor.service.GameService;

public class GameServiceImpl implements GameService {

    GameContainerImpl gameContainer = GameContainerImpl.getGameContainerImpl();

    @Override
    public void startGame(Game game) {
        game.start();
    }

    @Override
    public Game create(Game game) throws ServiceException {
        gameContainer.add(game);
        return game;
    }

    @Override
    public void pauseGame(int gameId) {
        gameContainer.get().get(gameId).pause();
    }

    @Override
    public Game resumeGame(int gameId) {
        return gameContainer.get().get(gameId).resume();
    }
}
