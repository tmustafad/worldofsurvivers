package com.turkmen.survivor.api.persistence;

import java.util.Map;


/**
 * <h1>The main interface of db simultaors,every data container implements this interface</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.persistence.impl.PlayerContainerImpl
 * @see com.turkmen.survivor.persistence.impl.CharacterContainerImpl
 * @see com.turkmen.survivor.persistence.impl.PlanetContainerImpl
 * @see com.turkmen.survivor.persistence.impl.GameContainerImpl
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public interface Container<T> {

    Map<Integer, T> get();

    T add(T t);

    T delete(T t);

}
