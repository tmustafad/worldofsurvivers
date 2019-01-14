package com.turkmen.survivor.service.impl.test;

import com.turkmen.survivor.api.model.Player;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlayerEntity;
import com.turkmen.survivor.service.impl.PlayerServiceImpl;
import com.turkmen.survivor.util.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class PlayerServiceImplTest {
    public static PlayerServiceImpl playerService;
    Player player;

    @BeforeAll
    static void beforeAllSetup() {
        playerService = GenericBuilder.of(PlayerServiceImpl::new).build();
    }

    @BeforeEach
    void setUp() {
        player = GenericBuilder.of(PlayerEntity::new)
                .with(PlayerEntity::setId, Utils.generateRandomInt())
                .with(PlayerEntity::setName, "Turkmen")
                .build();
    }

    @AfterEach
    void deleteCharacter() {
        playerService.getAll().clear();
    }

    @Test
    void create() {
        assertEquals("Turkmen", playerService.create(player).getName());
    }

    @Test
    void getAll() {
        playerService.create(player);
        assertNotNull(playerService.getAll());
    }
}