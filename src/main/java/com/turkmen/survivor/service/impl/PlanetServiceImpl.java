package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.Planet;
import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.persistence.impl.PlanetContainerImpl;
import com.turkmen.survivor.service.PlanetService;

public class PlanetServiceImpl implements PlanetService {
    PlanetContainerImpl planetContainerImpl = PlanetContainerImpl.getPlanetContainerImpl();

    @Override
    public Planet create(Planet planet) throws ServiceException {
        planetContainerImpl.add(planet);
        return planet;
    }
}
