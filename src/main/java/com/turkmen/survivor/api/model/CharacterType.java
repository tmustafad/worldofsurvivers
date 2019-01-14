package com.turkmen.survivor.api.model;
/**
 * <h1>The type of characters are being managed here. we can define other type of characters here also </h1>
 *
 *
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.CharacterEntity
 * @see com.turkmen.survivor.entitydto.CharacterDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public enum CharacterType {

    HUMAN("human", 100), DINOSAUR("dinosaur", 500), SHEEP("sheep", 30), COW("cow", 80), CHICKEN("chicken", 10), ALIEN("alien", 1000), GHOST("ghost", 2000);

    private String name;
    private int initialHealth;

    CharacterType(String name, int initialHealth) {
        this.name = name;
        this.initialHealth = initialHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
