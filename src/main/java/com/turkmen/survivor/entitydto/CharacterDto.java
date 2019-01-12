package com.turkmen.survivor.entitydto;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.CharacterType;

public class CharacterDto extends DefaultDto implements Character {

    private int id;

    private String name;

    private int health;

    private boolean alive;

    private CharacterType type;

    private int planetId;

    private int location;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public CharacterType getType() {
        return type;
    }

    @Override
    public int getPlanetId() {
        return planetId;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void setType(CharacterType type) {
        this.type = type;
    }

    @Override
    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public void setLocation(int locationx) {
        this.location = locationx;
    }


}
