package Levels;
import Game.Map;

public class TestLevel extends LevelSpec{
    private static final int STARTING_OXYGEN = 2000;
    private static final int OXYGEN_DECREASE_RATE = 2;
    private static final int TANK_DISAPPEAR_TIME = 15;
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.testLv;
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");
        LevelManager.gameManager.currentOxygen = STARTING_OXYGEN;
        LevelManager.gameManager.oxygenDecreaseRate = OXYGEN_DECREASE_RATE;
        LevelManager.gameManager.oxygenTankDisappearTime = TANK_DISAPPEAR_TIME;
    }
}
