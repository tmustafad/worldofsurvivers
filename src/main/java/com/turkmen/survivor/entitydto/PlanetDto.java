package com.turkmen.survivor.entitydto;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.Planet;

public class PlanetDto extends DefaultDto implements Planet {

    private int id;
    private Character[] matrix;
    private String name;


    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setMatrix(Character[] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Character[] getMatrix() {
        return new Character[0];
    }
}
