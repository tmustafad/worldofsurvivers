package com.turkmen.survivor.entitydto;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.Planet;



/**
 * <h1>The DTO is the transfer object between service-db layer and ui layer. {@link com.turkmen.survivor.ui.PlanetUI} </h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
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
        return this.matrix;
    }
}
