package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.api.service.PlanetService;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;
import com.turkmen.survivor.persistence.impl.PlanetContainerImpl;
import com.turkmen.survivor.ui.mapper.PlanetMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetServiceImpl implements PlanetService {
    PlanetContainerImpl planetContainerImpl = PlanetContainerImpl.getInstance();
    CharacterContainerImpl characterContainerImpl = CharacterContainerImpl.getInstance();

    @Override
    public Planet create(Planet planet) throws ServiceException {
        planetContainerImpl.add(planet);
        return planet;
    }

    @Override
    public List<Planet> getAll() throws ServiceException {
        return planetContainerImpl.getPlanets().values()
                .stream().collect(Collectors.toList());
    }

    @Override
    public Planet get(String name) {
        return planetContainerImpl.getPlanets().values()
                .stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public Planet update(Planet planet) {
        Planet p= planetContainerImpl.add(planet);
        return p;
    }





}
