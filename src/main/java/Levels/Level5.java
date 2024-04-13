package Levels;
import Game.Map;

public class Level5 extends LevelSpec{
    private static final int STARTING_OXYGEN = 2000;
    private static final int OXYGEN_DECREASE_RATE = 2;
    private static final int TANK_DISAPPEAR_TIME = 15;
    private static final int SELECTED_LEVEL = 5;
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.veryHardLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level5Map.txt");
        LevelManager.gameManager.level = SELECTED_LEVEL;
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
