package Levels;
import Game.Map;

public class Level4 extends LevelSpec{
    private static final int STARTING_OXYGEN = 2500;
    private static final int OXYGEN_DECREASE_RATE = 2;
    private static final int TANK_DISAPPEAR_TIME = 20;
    private static final int SELECTED_LEVEL = 4;
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.hardLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level4Map.txt");
        LevelManager.gameManager.level = SELECTED_LEVEL;
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
