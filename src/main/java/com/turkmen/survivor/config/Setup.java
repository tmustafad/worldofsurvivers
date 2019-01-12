package com.turkmen.survivor.config;

import com.turkmen.survivor.api.model.*;
import com.turkmen.survivor.api.model.Character;
import com.turkmen.survivor.builder.GenericBuilder;
import com.turkmen.survivor.ui.CharacterUI;
import com.turkmen.survivor.ui.GameUI;
import com.turkmen.survivor.ui.PlanetUI;
import com.turkmen.survivor.ui.PlayerUI;
import com.turkmen.survivor.util.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

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
        playerUI=GenericBuilder.of(PlayerUI::new).build();
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
        return planetUI.create(planetName);
    }

    private void createPlanetMatrix() {
        Character[] matrix = new Character[matrixSize];

        IntStream.range(1, dinosaurCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.DINOSAUR.getName(),
                CharacterType.DINOSAUR.getInitialHealth(), Boolean.TRUE, CharacterType.DINOSAUR, planetUI.getPlanetByName(planetName).getId(), i));

        IntStream.range(dinosaurCount + 1, sheepCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.SHEEP.getName(),
                CharacterType.SHEEP.getInitialHealth(), Boolean.TRUE, CharacterType.SHEEP, planetUI.getPlanetByName(planetName).getId(), i));

        IntStream.range(sheepCount + 1, cowCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.COW.getName(),
                CharacterType.COW.getInitialHealth(), Boolean.TRUE, CharacterType.COW, planetUI.getPlanetByName(planetName).getId(), i));

        IntStream.range(cowCount + 1, chickenCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.CHICKEN.getName(),
                CharacterType.CHICKEN.getInitialHealth(), Boolean.TRUE, CharacterType.CHICKEN, planetUI.getPlanetByName(planetName).getId(), i));

        IntStream.range(chickenCount + 1, alienCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.ALIEN.getName(),
                CharacterType.ALIEN.getInitialHealth(), Boolean.TRUE, CharacterType.ALIEN, planetUI.getPlanetByName(planetName).getId(), i));

        IntStream.range(alienCount + 1, ghostCount + 1).forEach(i -> matrix[i] = characterUI.create(CharacterType.GHOST.getName(),
                CharacterType.GHOST.getInitialHealth(), Boolean.TRUE, CharacterType.GHOST, planetUI.getPlanetByName(planetName).getId(), i));

        Character human = characterUI.create(CharacterType.HUMAN.getName(),
                CharacterType.HUMAN.getInitialHealth(), Boolean.TRUE, CharacterType.HUMAN, planetUI.getPlanetByName(planetName).getId(), 0);

        matrix[0] = human;
        Collections.shuffle(Arrays.asList(matrix));
        planetUI.getPlanetByName(planetName).setMatrix(matrix);
    }

    private Player createPlayer(String name){
        return playerUI.create(name);
    }

    public void createGame(String playerName) {
        Game game = gameUI.create();
        game.setPlanet(this.createPlanet());
        this.createPlanetMatrix();
        game.setPlayer(this.createPlayer(playerName));

    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public String getPlanetName() {
        return planetName;
    }

    public PlanetUI getPlanetUI() {
        return planetUI;
    }

    public CharacterUI getCharacterUI() {
        return characterUI;
    }

    public int getDinosaurCount() {
        return dinosaurCount;
    }

    public int getSheepCount() {
        return sheepCount;
    }

    public int getCowCount() {
        return cowCount;
    }

    public int getChickenCount() {
        return chickenCount;
    }

    public int getAlienCount() {
        return alienCount;
    }

    public int getGhostCount() {
        return ghostCount;
    }
}
