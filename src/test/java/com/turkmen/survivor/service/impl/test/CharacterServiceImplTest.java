package com.turkmen.survivor.service.impl.test;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.CharacterType;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.CharacterEntity;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;
import com.turkmen.survivor.service.impl.CharacterServiceImpl;
import com.turkmen.survivor.util.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharacterServiceImplTest {

    public static CharacterServiceImpl characterService;
    Character character;

    @BeforeEach
    void setUp() {
        character = GenericBuilder.of(CharacterEntity::new)
                .with(CharacterEntity::setId, Utils.generateRandomInt())
                .with(CharacterEntity::setHealth, 100)
                .with(CharacterEntity::setType, CharacterType.HUMAN)
                .build();
    }

    @AfterEach
    void deleteCharacter(){
        characterService.getAll().clear();
    }

    @BeforeAll
    static void beforeAllSetup() {
       characterService=GenericBuilder.of(CharacterServiceImpl::new).build();
    }



    @Test
    void create() {
        assertEquals(100,characterService.create(character).getHealth());
    }

    @Test
    void getAll() {
        characterService.create(character);
        assertNotNull(characterService.getAll());
    }


}