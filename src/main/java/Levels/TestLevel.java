package Levels;
import Game.Map;

public class TestLevel extends LevelSpec{
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.testLv;
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");
        LevelManager.gameManager.currentOxygen = 2000;
        LevelManager.gameManager.oxygenDecreaseRate = 2;
        LevelManager.gameManager.oxygenTankDisappearTime = 15;
    }
}
