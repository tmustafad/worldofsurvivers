package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;


/**
 * <h1>The interface for defining the service layer implementations of a character .</h1>
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.service.impl.CharacterServiceImpl
 * {@link Service}
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public interface CharacterService extends Service<Character> {

    Character attack(Character attacker, int targetId) throws ServiceException;

    Character find(String planetName,int sourceId,int location) throws ServiceException;

    Character delete(Character character) throws ServiceException;

}
