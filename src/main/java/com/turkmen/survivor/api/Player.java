package com.turkmen.survivor.api;

public interface Player {

    int getId();
    void setId(int id);

    String getName();

    void setName(String name);

    int getGameId();

    void setGameId(int gameId);

    int getScore();

    void setScore(int score);
}
