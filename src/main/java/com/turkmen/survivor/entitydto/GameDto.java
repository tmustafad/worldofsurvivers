package com.turkmen.survivor.entitydto;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.*;

public class GameDto extends DefaultDto implements Game {

    private Planet planet;
    private int id;
    private Player player;
    private boolean active;
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
    public Character find(CharacterType characterType) {
        return null;
    }

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Planet getPlanet() {
        return planet;
    }

    @Override
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
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
