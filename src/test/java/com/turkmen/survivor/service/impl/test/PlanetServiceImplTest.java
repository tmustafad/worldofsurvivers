package com.turkmen.survivor.service.impl.test;

import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlanetEntity;
import com.turkmen.survivor.service.impl.PlanetServiceImpl;
import com.turkmen.survivor.util.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlanetServiceImplTest {
    public static PlanetServiceImpl planetService;
    Planet planet;

    @BeforeEach
    void setUp() {
        planet = GenericBuilder.of(PlanetEntity::new)
                .with(PlanetEntity::setId, Utils.generateRandomInt())
                .with(PlanetEntity::setName, "World")
                .build();
    }

    @AfterEach
    void deleteCharacter(){
        planetService.getAll().clear();
    }

    @BeforeAll
    static void beforeAllSetup() {
        planetService=GenericBuilder.of(PlanetServiceImpl::new).build();
    }



    @Test
    void create() {
        assertEquals("World",planetService.create(planet).getName());
    }

    @Test
    void getAll() {
        planetService.create(planet);
        assertNotNull(planetService.getAll());
    }
}