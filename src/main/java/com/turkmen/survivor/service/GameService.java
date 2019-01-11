package com.turkmen.survivor.service;

import com.turkmen.survivor.api.Game;

public interface GameService extends Service<Game> {


    void startGame(Game game);

    void pauseGame(int gameId);

    Game resumeGame(int gameId);


}
