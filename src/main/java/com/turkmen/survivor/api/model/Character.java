package com.turkmen.survivor.api.model;


/**
 * <h1>The Interface which is being implemented by all character Entity and DTOs in the game.</h1>
 *The behaviours of the characters are strictly defined here
 *
 *
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.CharacterEntity
 * @see com.turkmen.survivor.entitydto.CharacterDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
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
