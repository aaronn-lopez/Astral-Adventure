package Levels;

public abstract class LevelSpec {
    public static LevelManager lvManager;
    public static void init(LevelManager level){
        lvManager = level;
    }
    public abstract void setSpecs();
}
