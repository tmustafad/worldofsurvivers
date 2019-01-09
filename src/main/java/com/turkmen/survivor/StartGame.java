package com.turkmen.survivor;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.CharacterType;
import com.turkmen.survivor.entity.CharacterEntity;
import com.turkmen.survivor.entity.GameEntity;
import com.turkmen.survivor.persistence.impl.GameContainerImpl;
import com.turkmen.survivor.builder.EntityBuilder;

import java.util.ArrayList;
import java.util.List;

public class StartGame {


    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);


        GameEntity gameEntity = EntityBuilder.of(GameEntity::new)
                .with(GameEntity::setId, 1)
                .with(GameEntity::setCharacters, createCharacterList())
                .build();

        GameContainerImpl container=GameContainerImpl.getGameContainerImpl();
        container.add(gameEntity);

        System.out.println("db   "+container.get().get(1).getCharacters().get(0).getName());
    }

    static private List<Character> createCharacterList() {
        List<Character> characters = new ArrayList();
        CharacterEntity characterEntity = EntityBuilder.of(CharacterEntity::new)
                .with(CharacterEntity::setAlive, true)
                .with(CharacterEntity::setHealth, 100)
                .with(CharacterEntity::setName, "Turkmen")
                .with(CharacterEntity::setType, CharacterType.HUMAN)
                .build();
        characters.add(characterEntity);
        return characters;
    }
}
