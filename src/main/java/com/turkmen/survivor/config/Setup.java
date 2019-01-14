package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.api.model.*;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.ui.CharacterUI;
import com.turkmen.survivor.ui.GameUI;
import com.turkmen.survivor.ui.PlanetUI;
import com.turkmen.survivor.ui.PlayerUI;
import com.turkmen.survivor.util.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;


/**
 * <h1>All initial creations and setups for the game to be started are managed here</h1>
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class Setup {

    int matrixSize;
    String planetName;
    private PlanetUI planetUI;
    private CharacterUI characterUI;
    private GameUI gameUI;
    private PlayerUI playerUI;
    private int dinosaurCount;
    private int sheepCount;
    private int cowCount;
    private int chickenCount;
    private int alienCount;
    private int ghostCount;


    {
        planetUI = GenericBuilder.of(PlanetUI::new).build();
        characterUI = GenericBuilder.of(CharacterUI::new).build();
        gameUI = GenericBuilder.of(GameUI::new).build();
        playerUI = GenericBuilder.of(PlayerUI::new).build();
        matrixSize = Integer.valueOf(Utils.getPropertyValue("world.matrix.size").get());
        planetName = Utils.getPropertyValue("planet.name").get();
        dinosaurCount = Integer.valueOf(Utils.getPropertyValue("world.game.dinosaur.count").get());
        sheepCount = Integer.valueOf(Utils.getPropertyValue("world.game.sheep.count").get());
        cowCount = Integer.valueOf(Utils.getPropertyValue("world.game.cow.count").get());
        chickenCount = Integer.valueOf(Utils.getPropertyValue("world.game.chicken.count").get());
        alienCount = Integer.valueOf(Utils.getPropertyValue("world.game.alien.count").get());
        ghostCount = Integer.valueOf(Utils.getPropertyValue("world.game.ghost.count").get());

    }

    private Planet createPlanet() {
        Planet planet=planetUI.create(planetName);
        return createPlanetMatrix(planet);
    }

    /**
     *Constructs the one dimensional array for all characters and put it into the planet
     * @param planet
     */
    private Planet createPlanetMatrix(Planet planet) {
        Character[] matrix = new Character[matrixSize];

        IntStream.range(1, dinosaurCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.DINOSAUR.getName(),
                CharacterType.DINOSAUR.getInitialHealth(), Boolean.TRUE, CharacterType.DINOSAUR, planet.getId(), i));


        IntStream.range(dinosaurCount + 1, dinosaurCount + sheepCount + 2).forEach(i -> matrix[i] = characterUI.create(CharacterType.SHEEP.getName(),
                CharacterType.SHEEP.getInitialHealth(), Boolean.TRUE, CharacterType.SHEEP, planet.getId(), i));


        IntStream.range(dinosaurCount + sheepCount + 2, dinosaurCount + sheepCount + cowCount + 2).forEach(i -> matrix[i] = characterUI.create(CharacterType.COW.getName(),
                CharacterType.COW.getInitialHealth(), Boolean.TRUE, CharacterType.COW, planet.getId(), i));


        IntStream.range(dinosaurCount + sheepCount + cowCount + 2, dinosaurCount + sheepCount + cowCount + chickenCount + 2).forEach(i -> matrix[i] = characterUI.create(CharacterType.CHICKEN.getName(),
                CharacterType.CHICKEN.getInitialHealth(), Boolean.TRUE, CharacterType.CHICKEN, planet.getId(), i));


        IntStream.range(dinosaurCount + sheepCount + cowCount + chickenCount + 2, dinosaurCount + sheepCount + cowCount + chickenCount + alienCount + 2).forEach(i -> matrix[i] = characterUI.create(CharacterType.ALIEN.getName(),
                CharacterType.ALIEN.getInitialHealth(), Boolean.TRUE, CharacterType.ALIEN,planet.getId(), i));


        IntStream.range(dinosaurCount + sheepCount + cowCount + chickenCount + alienCount + 2, dinosaurCount + sheepCount + cowCount + chickenCount + alienCount + ghostCount + 2).forEach(i -> matrix[i] = characterUI.create(CharacterType.GHOST.getName(),
                CharacterType.GHOST.getInitialHealth(), Boolean.TRUE, CharacterType.GHOST, planet.getId(), i));


        Character human = characterUI.create(CharacterType.HUMAN.getName(),
                CharacterType.HUMAN.getInitialHealth(), Boolean.TRUE, CharacterType.HUMAN, planet.getId(), 0);
        matrix[0] = human;
        Collections.shuffle(Arrays.asList(matrix));
        IntStream.range(0, matrixSize).filter(e -> matrix[e] != null).forEach(i -> matrix[i].setLocation(i));
        IntStream.range(0, matrixSize).filter(f -> matrix[f] != null).forEach(j -> characterUI.update(matrix[j]));

        planet.setMatrix(matrix);

        return planetUI.update(planet);
    }

    private Player createPlayer(String name) {
        Player player = playerUI.create(name);
        return playerUI.update(player);
    }


    public Game createGame(String playerName) {
        Game game = gameUI.create();
        Planet planet=this.createPlanet();
        game.setPlanet(planet);
        game.setPlayer(createPlayer(playerName));
        game.setStatus(GameStatus.NEW);
        game.setActive(Boolean.FALSE);
        gameUI.update(game);
        return game;
    }

    public PlanetUI getPlanetUI() {
        return planetUI;
    }

    public CharacterUI getCharacterUI() {
        return characterUI;
    }

    public GameUI getGameUI() {
        return gameUI;
    }

    public PlayerUI getPlayerUI() {
        return playerUI;
    }
}
