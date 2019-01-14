package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.CharacterType;

/**
 * <h1>The entity which is being kept by @{@link com.turkmen.survivor.persistence.impl.CharacterContainerImpl}</h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class CharacterEntity implements Character {

    private int id;

    private String name;

    private int health;

    private boolean alive;

    private CharacterType type;

    private int planetId;

    private int location;


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(int location) {
        this.location = location;
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


    public CharacterType getType() {
        return this.type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }
}
