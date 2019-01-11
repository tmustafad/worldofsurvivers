package com.turkmen.survivor.service.impl;

import com.turkmen.survivor.api.Character;
import com.turkmen.survivor.api.exception.ServiceException;
import com.turkmen.survivor.persistence.impl.CharacterContainerImpl;
import com.turkmen.survivor.service.CharacterService;

public class CharacterServiceImpl implements CharacterService {

    CharacterContainerImpl characterContainerImpl = CharacterContainerImpl.getcharacterContainerImpl();

    @Override
    public Character create(Character character) throws ServiceException {
        characterContainerImpl.add(character);
        return character;
    }
}
