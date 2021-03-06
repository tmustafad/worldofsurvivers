package com.turkmen.survivor.persistence.impl;

import com.turkmen.survivor.api.model.Planet;
import com.turkmen.survivor.api.persistence.Container;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>The  DB simulation, a hashmap is used for keeping the data throught game lifecycle. </h1>
 *
 * When a game starts a singelton container impl for every entity is created
 *
 * @see  Container
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class PlanetContainerImpl implements Container<Planet> {

    private static PlanetContainerImpl planetContainerImpl;

    Map<Integer, Planet> planets;

    {
        planets = new HashMap<Integer, Planet>();
    }

    private PlanetContainerImpl() {
        System.out.println("Planet Container initialized.........");
    }

    public static PlanetContainerImpl getInstance() {
        if (planetContainerImpl == null) {
            planetContainerImpl = new PlanetContainerImpl();
        }
        return planetContainerImpl;
    }

    @Override
    public Map<Integer, Planet> get() {
        return this.planets;
    }

    @Override
    public Planet add(Planet planet) {
        if (this.planets.containsKey(planet.getId())) {
            this.planets.replace(planet.getId(), planets.get(planet.getId()), planet);
            return this.planets.get(planet.getId());
        }

        return this.planets.put(planet.getId(), planet);
    }


    @Override
    public Planet delete(Planet planet) {
        if (this.planets.containsKey(planet.getId())) {
            this.planets.replace(planet.getId(), planets.get(planet.getId()), null);
            return this.planets.get(planet.getId());
        }

        return this.planets.put(planet.getId(), planet);
    }

    public Map<Integer, Planet> getPlanets() {
        return planets;
    }
}
