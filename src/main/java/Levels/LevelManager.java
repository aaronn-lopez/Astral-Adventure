package Levels;
import Game.*;

public class LevelManager {
    public LevelSpec easyLv = new Level1();
    public LevelSpec normalLv = new Level2();
    public LevelSpec intermediateLv = new Level3();
    public LevelSpec hardLv = new Level4();
    public LevelSpec veryHardLv = new Level5();
    public LevelSpec testLv = new TestLevel();

    public LevelSpec selectedLv;

    public static LevelManager lvManager;
    public  static GameManager gameManager;

    public LevelManager() {
        lvManager = this;
        gameManager = GameManager.gameManager;

        LevelSpec.init(this);
    }
}
