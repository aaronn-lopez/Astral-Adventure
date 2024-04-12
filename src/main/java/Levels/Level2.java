package Levels;
import Game.Map;

public class Level2 extends LevelSpec{
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.normalLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level2Map.txt");
        LevelManager.gameManager.currentOxygen = 3500;
        LevelManager.gameManager.oxygenDecreaseRate = 1;
        LevelManager.gameManager.oxygenTankDisappearTime = 30;
    }
}
