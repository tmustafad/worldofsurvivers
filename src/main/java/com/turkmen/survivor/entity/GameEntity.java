package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.*;


/**
 * <h1>The entity which is being kept by @{@link com.turkmen.survivor.persistence.impl.GameContainerImpl}</h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class GameEntity implements Game {

    private Planet planet;
    private int id;
    private Player player;
    private boolean active;
    private String name;
    private GameStatus gameStatus;

    @Override
    public GameStatus getStatus() {
        return this.gameStatus;
    }

    @Override
    public void setStatus(GameStatus gameStatus) {
    this.gameStatus=gameStatus;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Character find(CharacterType characterType) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Planet getPlanet() {
        return this.planet;
    }

    @Override
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
