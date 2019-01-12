package com.turkmen.survivor.api.model;

public interface Character {
    int getId();

    void setId(int id);

    int getLocation();

    void setLocation(int location);

    int getPlanetId();

    void setPlanetId(int planetId);

    String getName();

    void setName(String name);

    int getHealth();

    void setHealth(int health);

    boolean isAlive();

    void setAlive(boolean alive);


    CharacterType getType();

    void setType(CharacterType type);

}
