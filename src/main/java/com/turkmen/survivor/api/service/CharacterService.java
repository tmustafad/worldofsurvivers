package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.api.model.Character;

public interface CharacterService extends Service<Character> {

    Character attack(Character attacker, int targetId) throws ServiceException;

    Character find(String planetName,int sourceId,int location) throws ServiceException;

    Character delete(Character character) throws ServiceException;

}
