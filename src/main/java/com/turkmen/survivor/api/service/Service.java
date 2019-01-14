package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.exception.ServiceException;

import java.util.List;
/**
 * <h1>The very main interface for all service layer implementors.The behaviour is delegated to implementors via relevant interfaces like {@link GameService}</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.service.impl.CharacterServiceImpl
 * @see com.turkmen.survivor.service.impl.GameServiceImpl
 * @see com.turkmen.survivor.service.impl.PlayerServiceImpl
 * @see com.turkmen.survivor.service.impl.PlanetServiceImpl
 * {@link Service}
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public interface Service<T> {
    T create(T t) throws ServiceException;
    List<T> getAll() throws ServiceException;
    T get(String name);
    T update(T t);
}
