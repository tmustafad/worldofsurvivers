package com.turkmen.survivor;

import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.config.GameState;
import com.turkmen.survivor.config.Setup;
import com.turkmen.survivor.persistence.impl.PlayerContainerImpl;
import com.turkmen.survivor.ui.PlayerUI;

import java.util.Scanner;

public class StartGame {


    public static void main(String[] args) {

        String command;
        Scanner sc = new Scanner(System.in);
        Setup setup =GenericBuilder.of(Setup::new).build();
        GameState gameState=GenericBuilder.of(GameState::new).build();

        while (true) {
            System.out.println("****** WELCOME TO WORLD OF SURVIVERS ******");
            Game game=setup.createGame("turkmen");
            System.out.println(gameState.getGameState(game.getId()).toString());
        }

    }


}
