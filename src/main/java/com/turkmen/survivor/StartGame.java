package com.turkmen.survivor;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.CharacterType;
import com.turkmen.survivor.entity.PlanetEntity;
import com.turkmen.survivor.builder.EntityBuilder;
import com.turkmen.survivor.entity.CharacterEntity;
import com.turkmen.survivor.entity.GameEntity;
import com.turkmen.survivor.persistence.impl.GameContainerImpl;
import com.turkmen.survivor.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Utils.getPropertyValue("world.matrix.size.x").get());
        String command = null;
        while (command == null) {
            System.out.println("Welcome to World of Survivers. All you need to do is SURVIVE !!!");
            System.out.println("-------------------------------");
            System.out.println("To start a game ,please type start");
            command = scanner.next();
            if (command.equalsIgnoreCase("start")) {
                GameEntity gameEntity = EntityBuilder.of(GameEntity::new)
                        .with(GameEntity::setId, 1)
                        .with(GameEntity::setCharacters, createCharacterList())
                        .with(GameEntity::setPlanet,EntityBuilder.of(PlanetEntity::new)
                                .with(PlanetEntity::setName,"World").build())
                        .build();

                GameContainerImpl container = GameContainerImpl.getGameContainerImpl();
                container.add(gameEntity);

                System.out.println("db   " + container.get().get(1).getCharacters().get(0).getName());
            }
            command = null;
        }


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
