package com.turkmen.survivor.api;

public interface Game {

    Player getPlayer();
    void setPlayer(Player player);

    Planet getPlanet();

    void setPlanet(Planet planet);


    int getId();

    void setId(int id);

    void start();

    Game resume();

    void pause();

    Character findAndAttack(CharacterType characterType);


}
