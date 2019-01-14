package com.turkmen.survivor.api.model;



/**
 * <h1>The place where all characters are residing. Every game contains a planet and a planet contains a matrix where the characters reside </h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.entity.PlanetEntity
 * @see com.turkmen.survivor.entitydto.PlanetDto
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public interface Planet {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    Character[] getMatrix();

    void setMatrix(Character[] matrix);

}
