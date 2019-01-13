package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.Character;
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
        String characterType = characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findFirst().get().getType().getName();
        String numOfDinosaur = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.DINOSAUR.getName())
                && c.getHealth() > 0).count());
        String numOfSheep = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.SHEEP.getName())
                && c.getHealth() > 0).count());
        String numOfCow = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.COW.getName())
                && c.getHealth() > 0).count());

        String numOfChicken = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.CHICKEN.getName())
                && c.getHealth() > 0).count());

        String numOfAlien = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.ALIEN.getName())
                && c.getHealth() > 0).count());

        String numOfGhost = String.valueOf(characterUI.getAllCharacters().stream().filter(c -> c.getType().getName().equalsIgnoreCase(CharacterType.GHOST.getName())
                && c.getHealth() > 0).count());

        StringJoiner sj = new StringJoiner("\n");
        Game game = gameUI.getAllGames().stream().filter(g -> g.getId() == id).findFirst().get();
        sj.add("*********************************************");
        sj.add("Player Name: " + game.getPlayer().getName());
        sj.add("Game Id :" + game.getId());
        String gameStatus = game.isActive() ? "Active" : "Not Active";
        sj.add("Game Status :" + gameStatus);
        sj.add("Character Type :" + characterType);
        sj.add("Character Health : " + health);
        sj.add("Character Location : " + location);
        sj.add("Number of Dinosaur : " + numOfDinosaur);
        sj.add("Number of Sheep : " + numOfSheep);
        sj.add("Number of Cow : " + numOfCow);
        sj.add("Number of Chicken : " + numOfChicken);
        sj.add("Number of Alien : " + numOfAlien);
        sj.add("Number of DGhost : " + numOfGhost);
        sj.add("*********************************************");
        return sj;
    }

    public StringJoiner showCharacterDetails(Character character) {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("Type : " + character.getType().getName());
        sj.add("Name : " + character.getName());
        sj.add("Health : " + character.getHealth());
        String alive = character.isAlive() ? "Yes" : "No";
        sj.add("Alive : " + alive);
        sj.add("Planet Id : " + character.getPlanetId());
        sj.add("Location : " + character.getLocation());
        return sj;
    }

    public StringJoiner welcomeMessage(){
        StringJoiner sj = new StringJoiner("\n");
        sj.add("****** WELCOME TO THE WORLD OF SURVIVERS ******");
        sj.add("AS A HUMAN,ARE YOU STRONG ENOUGH TO SURVIVE IN A WORLD OF MONSTERS?");
        sj.add("Enter Your Name :");
        return sj;
    }


    public Game updateGameState(Game game){
        return gameUI.update(game);
    }

}
