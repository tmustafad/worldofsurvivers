package com.turkmen.survivor.api.model;

public interface Game {

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
