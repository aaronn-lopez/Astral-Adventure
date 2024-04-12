package Levels;
import Game.Map;

public class Level4 extends LevelSpec{
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.hardLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level4Map.txt");
        LevelManager.gameManager.currentOxygen = 2500;
        LevelManager.gameManager.oxygenDecreaseRate = 2;
        LevelManager.gameManager.oxygenTankDisappearTime = 20;
    }
}
