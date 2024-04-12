package Levels;
import Game.Map;

public class Level3 extends LevelSpec{
    @Override
    public void setSpecs() {
        lvManager.selectedLv = lvManager.intermediateLv;
        Map map = new Map();
        map.newMap("src/main/maps/Level3Map.txt");
        LevelManager.gameManager.currentOxygen = 3000;
        LevelManager.gameManager.oxygenDecreaseRate = 1;
        LevelManager.gameManager.oxygenTankDisappearTime = 20;
    }
}
