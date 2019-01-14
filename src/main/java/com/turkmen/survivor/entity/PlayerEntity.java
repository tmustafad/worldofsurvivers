package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.model.Player;
/**
 * <h1>The entity which is being kept by @{@link com.turkmen.survivor.persistence.impl.PlayerContainerImpl}</h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlayerEntity implements Player {

    private int id;
    private int gameId;
    private String name;
    private int score;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getGameId() {
        return this.gameId;
    }

    @Override
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
