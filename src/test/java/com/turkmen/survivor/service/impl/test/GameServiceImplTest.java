package com.turkmen.survivor.service.impl.test;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.GameEntity;
import com.turkmen.survivor.service.impl.GameServiceImpl;
import com.turkmen.survivor.util.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameServiceImplTest {
    public static GameServiceImpl gameService;
    Game game;

    @BeforeEach
    void setUp() {
        game = GenericBuilder.of(GameEntity::new)
                .with(GameEntity::setId, Utils.generateRandomInt())
                .with(GameEntity::setName, "World Of Suriviers")
                .build();
    }

    @AfterEach
    void deleteCharacter(){
        gameService.getAll().clear();
    }

    @BeforeAll
    static void beforeAllSetup() {
        gameService=GenericBuilder.of(GameServiceImpl::new).build();
    }



    @Test
    void create() {
        assertEquals("World Of Suriviers",gameService.create(game).getName());
    }

    @Test
    void getAll() {
        gameService.create(game);
        assertNotNull(gameService.getAll());
    }

}