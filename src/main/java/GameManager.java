import java.util.ArrayList;

/**
 * <p>Singleton. Contains a majority of the internal information about the current game state.</p>
 */
public class GameManager {
    static GameManager gameManager;
    int framesPerTick = 40;
    int score = 0;
    int baseScore = 0;
    int completionCount = 0;
    int totalBatteries = 0;
    int oxygen = 4000;
    int maxOxygen = 4000;
    int oxygenRate = 1;
    int gridX = 8;
    int gridY = 8;
    int elapsedTime = 0;
    int level;
    int oxygenTankDisappearTime;
    Scoreboard scoreboard;

    boolean justTeleported = false;

    Cell[][] cells;

    public Gameobject player;
    public ArrayList<Gameobject> enemies;

    GameManager(){
        gameManager = this;
        gameManager.enemies = new ArrayList<Gameobject>();
        gameManager.scoreboard = new Scoreboard();
    }

    /**
     *
     * @param object Object to be instantiated
     * @param x grid X position
     * @param y grid Y position
     */
    public static void instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        Gameobject gameobject = null;
        switch(object){
            case Player:
                gameobject = new Player(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].player = gameobject;
                gameobject.setPosition(x, y);
                gameManager.player = gameobject;
                break;
            case WalkingAlien:
                gameobject = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).enemy = gameobject;
                gameobject.setPosition(x, y);
                gameManager.enemies.add(gameobject);
                break;
            case HidingAlien:
                gameobject = new Spike(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).enemy = gameobject;
                gameobject.setPosition(x, y);
                gameManager.enemies.add(gameobject);
                break;
            case OxygenTank:
                gameobject = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case Battery:
                gameobject = new Battery(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case Blackhole:
                gameobject = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case EndTile:
                gameobject = new EndTile(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            default:
                break;
        }
    }

    /**
     * <p>Reset the game manager for a new level.</p>
     */
    public static void reset(){
        gameManager.score = 0;
        gameManager.enemies.clear();
        gameManager.completionCount = 0;
        gameManager.totalBatteries = 0;
        gameManager.elapsedTime = 0;
    }

    /**
     * <p>Load the proper level parameters, and start the level.</p>
     * @param level Level number
     */
    public void startLevel(int level){
        Map map = new Map();
        map.newMap("src/main/maps/Level" + level + "Map.txt");
        this.level = level;

        switch(level)
        {
            case 1:
                gameManager.oxygen = 4000;
                gameManager.oxygenRate = 1;
                gameManager.oxygenTankDisappearTime = 45;
                break;
            case 2:
                gameManager.oxygen = 3500;
                gameManager.oxygenRate = 1;
                gameManager.oxygenTankDisappearTime = 30;
                break;
            case 3:
                gameManager.oxygen = 3000;
                gameManager.oxygenRate = 1;
                gameManager.oxygenTankDisappearTime = 20;
                break;
            case 4:
                gameManager.oxygen = 2500;
                gameManager.oxygenRate = 2;
                gameManager.oxygenTankDisappearTime = 20;
                break;
            case 5:
                gameManager.oxygen = 2000;
                gameManager.oxygenRate = 2;
                gameManager.oxygenTankDisappearTime = 15;
                break;
            default:
                break;
        }
    }

    /**
     * <p>Method to retrieve a given cell given x and y grid coordinates.</p>
     * @param x cell X position
     * @param y cell Y position
     * @return returns the cell at the x, y, position
     */
    public static Cell getCell(int x, int y){
        return gameManager.cells[x][y];
    }

    /**
     * <p>Method to retrieve the enemy at a given x, y position</p>
     * @param x grid X position
     * @param y grid Y position
     * @return returns the enemy at the x, y, position
     */
    public static Enemy getEnemy(int x, int y){
        return (Enemy)getCell(x, y).enemy;
    }

    /**
     * <p>Method to retrieve the object at a given x, y position</p>
     * @param x grid X position
     * @param y grid Y position
     * @return returns the object at the x, y, position
     */
    public static Gameobject getObject(int x, int y){
        return getCell(x, y).interactable;
    }
}