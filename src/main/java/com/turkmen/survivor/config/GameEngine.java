package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.Character;

public class GameEngine {

    public Character attack(Character attacker, Character target) {
        int attackerHealth = attacker.getHealth();
        int targetHealth = target.getHealth();

        attacker.setHealth(attackerHealth > targetHealth ? attackerHealth + targetHealth : attackerHealth - targetHealth);
        return attacker;
    }

    public Character withdrawSearchingCost(Character character) {
        character.setHealth(character.getHealth() - 1);
        return character;
    }

    public boolean isCharacterDead(Character character) {
        return character.getHealth() <= 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
