package Levels;
import Game.Map;

public class Level5 extends LevelSpec{
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.veryHardLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level5Map.txt");
        LevelManager.gameManager.currentOxygen = 2000;
        LevelManager.gameManager.oxygenDecreaseRate = 2;
        LevelManager.gameManager.oxygenTankDisappearTime = 15;
    }
}
