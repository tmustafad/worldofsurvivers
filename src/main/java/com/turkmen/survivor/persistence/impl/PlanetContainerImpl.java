package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.Planet;
import com.turkmen.survivor.persistence.Container;

import java.util.HashMap;
import java.util.Map;

public class PlanetContainerImpl implements Container<Planet> {

    private static PlanetContainerImpl planetContainerImpl = null;

    Map<Integer, Planet> planets;

    {
        planets = new HashMap<Integer, Planet>();
    }

    private PlanetContainerImpl() {
        System.out.println("Planet Container initialized.........");
    }

    public static PlanetContainerImpl getPlanetContainerImpl() {
        if (planetContainerImpl == null) {
            return new PlanetContainerImpl();
        }
        return planetContainerImpl;
    }

    @Override
    public Map<Integer, Planet> get() {
        return this.planets;
    }

    @Override
    public void add(Planet planet) {
        this.planets.put(planet.getId(), planet);
    }
}
