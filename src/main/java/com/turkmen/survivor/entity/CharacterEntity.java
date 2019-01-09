package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.CharacterType;

public class CharacterEntity implements Character {

    private String name;

    private int health;

    private boolean alive;

    private CharacterType type;



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
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
