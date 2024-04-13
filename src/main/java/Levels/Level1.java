/**
 * Represents the specifications for Level 1 in the game.
 * The other 5 classes follow a similar format
 * corresponding to each level's specifications.
 */
package Levels;

import Game.Map;

public class Level1 extends LevelSpec {
    private static final int STARTING_OXYGEN = 4000;
    private static final int OXYGEN_DECREASE_RATE = 1;
    private static final int TANK_DISAPPEAR_TIME = 45;
    private static final int SELECTED_LEVEL = 1;

    /**
     * Sets the specifications for Level 1.
     * This includes selecting the level difficulty, creating a new map,
     * and setting the initial oxygen level, oxygen decrease rate, and oxygen tank disappear time.
     */
    @Override
    public void setSpecs() {
        // Select the easy level for the game
        lvManager.selectedLv = lvManager.easyLv;

        // Create a new map for Level 1
        Map map = new Map();
        map.newMap("src/main/maps/Level1Map.txt");

        LevelManager.gameManager.level = SELECTED_LEVEL;

        // Set the initial oxygen level for the game
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;

        // Set the rate at which oxygen decreases in the game
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;

        // Set the time after which an oxygen tank disappears in the game
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
