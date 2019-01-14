package com.turkmen.survivor.api.model;


/**
 * <h1>The scope and behaviour of the game is defined by this interface.</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.GameEntity
 * @see com.turkmen.survivor.entitydto.GameDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public interface Game {


    GameStatus getStatus();
    void setStatus(GameStatus gameStatus);

    String getName();
    void setName(String name);

    boolean isActive();

    void setActive(boolean active);

    Player getPlayer();

    void setPlayer(Player player);

    Planet getPlanet();

    void setPlanet(Planet planet);


    int getId();

    void setId(int id);


    Character find(CharacterType characterType);


}
