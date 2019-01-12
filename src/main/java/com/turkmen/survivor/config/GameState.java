package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.CharacterType;
import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.ui.CharacterUI;
import com.turkmen.survivor.ui.GameUI;

import java.util.Arrays;
import java.util.StringJoiner;

public class GameState {

    GameUI gameUI= GenericBuilder.of(GameUI::new).build();
    CharacterUI characterUI=GenericBuilder.of(CharacterUI::new).build();

    public StringJoiner getGameState(int id){
        String health=String.valueOf(characterUI.getAllCharacters().stream().filter(c->c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getHealth());
        String location =String.valueOf(characterUI.getAllCharacters().stream().filter(c->c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getLocation());
        StringJoiner sj= new StringJoiner("\n");
        Game game=gameUI.getAllGames().stream().filter(g->g.getId()== id).findFirst().get();
        sj.add("Player Name: "+game.getPlayer().getName());
        String gameStatus=game.isActive() ? "Active":"Not Active";
        sj.add("Game Status :" +gameStatus );
        sj.add("Player Health : "+health);
        sj.add("Player Location : "+location);
        return sj;
    }
}
