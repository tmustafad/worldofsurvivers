package com.turkmen.survivor.api;

public interface Character {

    String getName();

    void setName(String name);

    int getHealth();

    void setHealth(int health);

    boolean isAlive();

    void setAlive(boolean alive);


    void defend();

    CharacterType getType();

    void setType(CharacterType type);

}
