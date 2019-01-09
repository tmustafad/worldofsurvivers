package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.*;

public class GameEntity implements Game {

    private Planet planet;
    private int id;
    private Player player;

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Character findAndAttack(CharacterType characterType) {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

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


}
