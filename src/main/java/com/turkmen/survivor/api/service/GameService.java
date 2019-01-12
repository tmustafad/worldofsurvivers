package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.model.Game;

public interface GameService extends Service<Game> {


    void startGame(Game game);

    void pauseGame(int gameId);

    Game resumeGame(int gameId);


}
