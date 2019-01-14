package com.turkmen.survivor;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.CharacterType;
import com.turkmen.survivor.api.model.Game;
import com.turkmen.survivor.api.model.GameStatus;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.config.GameState;
import com.turkmen.survivor.config.Setup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1> The main class for the application. The main method is here </h1>
 *
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class StartGame {
    static Setup setup = GenericBuilder.of(Setup::new).build();
    static GameState gameState = GenericBuilder.of(GameState::new).build();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command;
        String playerName;
        int searchLocation;
        System.out.println(gameState.welcomeMessage());
        playerName = sc.next();

        Game game = setup.createGame(playerName);
        System.out.println("Hello " + playerName+" Please enter a valid command to start the game.....");

        Character playerCharacter = null;
        boolean invalidCommand = false;
        Character character = null;
        while (true) {
            System.out.println("Please enter a valid command !");
            command = sc.next();

            switch (command) {
                case "start":
                    if(game.getStatus().getCode() == GameStatus.LOST.getCode()){
                        System.out.println("You already lost the game ...Try Again ");
                        System.exit(3);
                    }
                    else if(game.getStatus().getCode() == GameStatus.NEW.getCode()){
                        game.setActive(Boolean.TRUE);
                        game.setStatus(GameStatus.ACTIVE);
                        playerCharacter = Arrays.stream(game.getPlanet().getMatrix())
                                .filter(c -> c != null && c.getType().getName().equalsIgnoreCase(CharacterType.HUMAN.getName())).findAny().get();
                        gameState.updateGameState(game);
                        System.out.println(gameState.getGameState(game.getId()));
                        System.out.println("Search the planet for hunting? Find food to get power !");
                        break;
                    }
                    else{
                        System.out.println("Your game may either be paused or win. You can resume the game or start over again ..");
                        break;
                    }


                case "find":
                    if (game.getStatus().getCode() == GameStatus.ACTIVE.getCode()) {
                        System.out.print("Enter a location code : ");
                        searchLocation = sc.nextInt();
                        character=setup.getCharacterUI().find("World",playerCharacter.getId(),searchLocation);
                        if (character != null) {
                            System.out.println("A character is found in given location, below are the details of it. You wanna attack or skip?");
                            System.out.println(gameState.showCharacterDetails(character));
                        }
                        else{
                            System.out.println("There is no food in this location,try different areas of the planet!");
                        }

                    }
                    else{
                        System.out.println("The game is not in active state, you can start new game or resume an ongoing game !!!");
                    }

                    break;
                case "attack":
                    if (game.getStatus().getCode() == GameStatus.ACTIVE.getCode()) {
                        if (character == null) {
                            System.out.println("Invalid Command,Please first find a character to attack...!");
                            break;
                        }
                        Character attacker=setup.getCharacterUI().attack(playerCharacter, character.getId());
                        if(attacker.getHealth()<=0){
                            System.out.println("Attacked but unfortunately died. !");
                            System.out.println(gameState.getGameState(game.getId()));
                            System.exit(3);
                        }
                        else{
                            setup.getCharacterUI().delete(character);
                            System.out.println("You killed it.Your health is increased...");
                        }

                    }


                    System.out.println(gameState.getGameState(game.getId()));
                    break;


                case "save":
                    if(game.getStatus().getCode()== GameStatus.ACTIVE.getCode()){
                        game.setActive(Boolean.FALSE);
                        game.setStatus(GameStatus.PAUSED);
                        gameState.updateGameState(game);
                        System.out.println("Your game is saved. You can resume anytime by entering resume command.");
                    }
                    else
                        System.out.println("You can not save an inactive game! ");
                    break;

                case "resume":
                    if(game.getStatus().getCode() == GameStatus.PAUSED.getCode()){
                        game.setActive(Boolean.TRUE);
                        game.setStatus(GameStatus.ACTIVE);
                        gameState.updateGameState(game);
                        System.out.println("Your game resumed..You can now discover the planet and attack!");
                    }
                    else
                        System.out.println("You can onle resume a paused game! ");
                    break;


                case "status":
                    if(game.getStatus().getCode() != GameStatus.LOST.getCode())
                    System.out.println(gameState.getGameState(game.getId()));
                    else
                        System.out.println("You can not check a finished game status..");
                default:
                    System.out.println("Invalid Command.! Please enter a valid command.");
            }


        }

    }


}
