package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.CharacterType;

public class CharacterEntity implements Character {

    private String name;

    private int health;

    private boolean alive;

    private CharacterType type;
    private int planetId;
    private int locationx;
    private int locationy;

    @Override
    public int getLocationx() {
        return this.locationx;
    }

    @Override
    public void setLocationx(int locationx) {
        this.locationx = locationx;
    }

    @Override
    public int getLocationy() {
        return this.locationy;
    }

    @Override
    public void setLocationy(int locationy) {
        this.locationy = locationy;
    }

    @Override
    public int getPlanetId() {
        return this.planetId;
    }

    @Override
    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return false;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public void defend() {

    }

    public CharacterType getType() {
        return null;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }
}
