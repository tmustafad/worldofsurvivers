package com.turkmen.survivor.entity;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.Planet;

import java.util.List;


/**
 * <h1>The entity which is being kept by @{@link com.turkmen.survivor.persistence.impl.PlanetContainerImpl}</h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlanetEntity implements Planet {

    private int id;
    private Character[] matrix;
    private String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public Character[] getMatrix() {
        return this.matrix;
    }

    @Override
    public void setMatrix(Character[] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
