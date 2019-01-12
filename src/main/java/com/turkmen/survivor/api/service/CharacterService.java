package com.turkmen.survivor.api.service;

import com.turkmen.survivor.api.model.Character;

public interface CharacterService extends Service<Character> {


    void attack(Character attacker,int targetId);
}
