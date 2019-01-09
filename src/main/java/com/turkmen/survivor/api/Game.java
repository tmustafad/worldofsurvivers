package com.turkmen.survivor.api;

import java.util.List;

public interface Game {




    List<Character> getCharacters();

    void setCharacters(List<Character> characters);

    int getId();

    void setId(int id);

    void start();

    void resume();

    void pause();

    Character findAndAttack(CharacterType characterType);


}
