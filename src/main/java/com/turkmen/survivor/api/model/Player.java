package com.turkmen.survivor.api.model;
/**
 * <h1>The person who starts the game and the person who can take actions on a game like resume,save etc.</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.PlayerEntity
 * @see com.turkmen.survivor.entitydto.PlayerDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
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
