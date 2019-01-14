package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.Character;
/**
 * <h1>The basic class for handling character behaviours.Basically this class is generated for clean code.</h1>
 *
 *
 * @author  Turkmen
 * @see com.turkmen.survivor.service.impl.CharacterServiceImpl
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class GameEngine {


    /**
     * @param attacker the user who is playing the game and the character type is human
     * @param  target  the character who is about to be attacked by human
     */
    public Character attack(Character attacker, Character target) {
        int attackerHealth = attacker.getHealth();
        int targetHealth = target.getHealth();

        attacker.setHealth(attackerHealth > targetHealth ? attackerHealth + targetHealth : attackerHealth - targetHealth);
        return attacker;
    }

    /**
     * @param character Every search operation costs a loss  of health in the game, and here it is applied.
     */
    public Character withdrawSearchingCost(Character character) {
        character.setHealth(character.getHealth() - 1);
        return character;
    }


    /**
     * @param character The character to be checked if it is dead or not
     */
    public boolean isCharacterDead(Character character) {
        return character.getHealth() <= 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
