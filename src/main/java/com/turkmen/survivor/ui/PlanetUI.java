package com.turkmen.survivor.ui;

import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.api.service.PlanetService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entitydto.PlanetDto;
import com.turkmen.survivor.service.impl.PlanetServiceImpl;
import com.turkmen.survivor.ui.mapper.PlanetMapper;
import com.turkmen.survivor.util.Utils;

import java.util.List;

public class PlanetUI {


    PlanetService planetService = GenericBuilder.of(PlanetServiceImpl::new).build();


    public Planet create(String name) {
        PlanetDto dto = GenericBuilder.of(PlanetDto::new)
                .with(PlanetDto::setName, name)
                .with(PlanetDto::setId, Utils.generateRandomInt())
                .build();
        Planet planetEntity = PlanetMapper.makePlanetEntity(dto);
        planetService.create(planetEntity);
        return dto;
    }

    public Planet update(Planet planet){
        return planetService.update(planet);
    }

    public List<Planet> getAllPlanets() {
        return PlanetMapper.makePlanetDtoList(planetService.getAll());
    }

    public Planet getPlanetByName(String name) {
        return planetService.get(name);
    }
}
