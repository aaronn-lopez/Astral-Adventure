package Levels;
import Game.Map;

public class Level3 extends LevelSpec{
    private static final int STARTING_OXYGEN = 3000;
    private static final int OXYGEN_DECREASE_RATE = 1;
    private static final int TANK_DISAPPEAR_TIME = 20;
    private static final int SELECTED_LEVEL = 3;
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.intermediateLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level3Map.txt");
        LevelManager.gameManager.level = SELECTED_LEVEL;
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
