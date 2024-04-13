package Levels;
import Game.Map;

public class Level2 extends LevelSpec{
    private static final int STARTING_OXYGEN = 3500;
    private static final int OXYGEN_DECREASE_RATE = 1;
    private static final int TANK_DISAPPEAR_TIME = 30;
    private static final int SELECTED_LEVEL = 2;
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.normalLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level2Map.txt");
        LevelManager.gameManager.level = SELECTED_LEVEL;
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
