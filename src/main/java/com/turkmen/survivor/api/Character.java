package com.turkmen.survivor.api;

public interface Character {

    int getLocationx();
    void setLocationx(int locationx);

    int getLocationy();
    void setLocationy(int locationy);

    int getPlanetId();

    void setPlanetId(int planetId);

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
