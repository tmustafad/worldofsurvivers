package com.turkmen.survivor.ui.mapper;

import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entity.PlanetEntity;
import com.turkmen.survivor.entitydto.PlanetDto;

import java.util.List;
import java.util.stream.Collectors;

public class PlanetMapper {

    /**
     * <h1> The Planet mapper between Entity and DTOs</h1>
     *
     *
     * @see  @{@link com.turkmen.survivor.ui.PlanetUI}
     * @author  Turkmen
     * @version 1.0
     * @since   2019-01-14
     *
     *
     */
    public static PlanetEntity makePlanetEntity(Planet planetDto) {
        PlanetEntity p= GenericBuilder.of(PlanetEntity::new)
                .with(PlanetEntity::setId, planetDto.getId())
                .with(PlanetEntity::setName, planetDto.getName())
                .with(PlanetEntity::setMatrix, planetDto.getMatrix())
                .build();
        return p;
    }


    public static PlanetDto makePlanetDto(Planet planetEntity) {
        PlanetDto p= GenericBuilder.of(PlanetDto::new)
                .with(PlanetDto::setId, planetEntity.getId())
                .with(PlanetDto::setName, planetEntity.getName())
                .with(PlanetDto::setMatrix, planetEntity.getMatrix())
                .build();
        return p;
    }


    public static List<Planet> makePlanetDtoList(List<Planet> planets) {
        return planets.stream().map(c -> GenericBuilder.of(PlanetDto::new)
                .with(PlanetDto::setId, c.getId())
                .with(PlanetDto::setName, c.getName())
                .with(PlanetDto::setMatrix, c.getMatrix())
                .build()).collect(Collectors.toList());
    }


}
