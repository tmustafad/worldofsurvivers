package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.CharacterType;
import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.ui.CharacterUI;
import com.turkmen.survivor.ui.GameUI;

import java.util.StringJoiner;

public class GameState {

    GameUI gameUI = GenericBuilder.of(GameUI::new).build();
    CharacterUI characterUI = GenericBuilder.of(CharacterUI::new).build();

    public StringJoiner getGameState(int id) {
        String health = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getHealth());
        String location = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getLocation());
        String characterType=String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getType().getName());
        StringJoiner sj = new StringJoiner("\n");
        Game game = gameUI.getAllGames().stream().filter(g -> g.getId() == id).findFirst().get();
        sj.add("Player Name: " + game.getPlayer().getName());
        sj.add("Game Id :"+game.getId());
        String gameStatus = game.isActive() ? "Active" : "Not Active";
        sj.add("Game Status :" + gameStatus);
        sj.add("Character Type :" + characterType);
        sj.add("Character Health : " + health);
        sj.add("Character Location : " + location);
        return sj;
    }
}
