package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.api.service.GameService;
import com.turkmen.survivor.persistence.impl.GameContainerImpl;

import java.util.List;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService {

    GameContainerImpl gameContainer = GameContainerImpl.getInstance();

    @Override
    public void startGame(Game game) {
        game.setActive(Boolean.TRUE);
    }

    @Override
    public Game create(Game game) throws ServiceException {
        gameContainer.add(game);
        return game;
    }

    @Override
    public void pauseGame(int gameId) {
        gameContainer.get().get(gameId).setActive(Boolean.FALSE);
    }

    @Override
    public Game resumeGame(int gameId) {
         gameContainer.get().get(gameId).setActive(Boolean.TRUE);
        return gameContainer.get().get(gameId);
    }

    @Override
    public Game get(String name) {
        return gameContainer.getGames().values()
                .stream().filter(g->g.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public List<Game> getAll() throws ServiceException {
        return gameContainer.getGames().values()
                .stream().collect(Collectors.toList());
    }

    @Override
    public Game update(Game game) {
        return gameContainer.getGames().put(game.getId(),game);
    }
}
