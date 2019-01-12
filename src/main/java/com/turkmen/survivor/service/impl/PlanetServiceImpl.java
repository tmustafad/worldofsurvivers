package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.api.service.PlanetService;
import com.turkmen.survivor.entity.PlanetEntity;
import com.turkmen.survivor.persistence.impl.PlanetContainerImpl;

import java.util.List;
import java.util.stream.Collectors;

public class PlanetServiceImpl implements PlanetService {
    PlanetContainerImpl planetContainerImpl = PlanetContainerImpl.getInstance();

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
                .stream().filter(p->p.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public Planet update(Planet planet) {
        return planetContainerImpl.getPlanets().put(planet.getId(),planet);
    }
}
