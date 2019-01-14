package com.turkmen.survivor.ui;

import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.api.service.PlanetService;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.entitydto.PlanetDto;
import com.turkmen.survivor.service.impl.PlanetServiceImpl;
import com.turkmen.survivor.ui.mapper.PlanetMapper;
import com.turkmen.survivor.util.Utils;

import java.util.List;
/**
 * <h1> The Game User Interaction class,a simulation of a controller. All manipulations are handled via service layer.</h1>
 *
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlanetUI {


    PlanetService planetService = GenericBuilder.of(PlanetServiceImpl::new).build();


    public PlanetDto create(String name) {
        PlanetDto dto = GenericBuilder.of(PlanetDto::new)
                .with(PlanetDto::setName, name)
                .with(PlanetDto::setId, Utils.generateRandomInt())
                .build();
        Planet planetEntity = PlanetMapper.makePlanetEntity(dto);
        planetService.create(planetEntity);
        return dto;
    }


    public PlanetDto update(Planet planet) {
        return PlanetMapper.makePlanetDto(planetService.update(PlanetMapper.makePlanetEntity(planet)));
    }

    public List<Planet> getAllPlanets() {
        return PlanetMapper.makePlanetDtoList(planetService.getAll());
    }

    public PlanetDto getPlanetByName(String name) {
        return PlanetMapper.makePlanetDto(planetService.get(name));
    }
}
