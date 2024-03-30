import java.util.ArrayList;
import java.util.List;

/**
 * <p>Singleton. Contains a majority of the internal information about the current game state.</p>
 */
public class GameManager {
    static GameManager gameManager;

    /**
     * <p>The amount of frames per game clock tick.</p>
     */
    int framesPerTick = 40;

    /**
     * <p>The player's current, final score.</p>
     */
    int score = 0;

    /**
     * <p>The player's score before additional calculations for extra oxygen, and time elapsed.</p>
     */
    int baseScore = 0;

    /**
     * <p>The player's current amount of collected batteries.</p>
     */
    int completionCount = 0;

    /**
     * <p>The total amount of batteries in the current level.</p>
     */
    int totalBatteries = 0;

    /**
     * <p>The player's current oxygen levels.</p>
     */
    int oxygen = 4000;

    /**
     * <p>The player's maximum oxygen.</p>
     */
    int maxOxygen = 4000;

    /**
     * <p>The rate at which oxygen is decreased in the current level.</p>
     */
    int oxygenRate = 1;

    /**
     * <p>The x dimension of the game board.</p>
     */
    int gridX = 8;

    /**
     * <p>The y dimension of the game board.</p>
     */
    int gridY = 8;

    /**
     * <p>The amount of time elapsed since starting the level.</p>
     */
    int elapsedTime = 0;

    /**
     * <p>The current level number</p>
     */
    int level;

    /**
     * <p>The amount of time that should pass before the oxygen tanks disappear.</p>
     */
    int oxygenTankDisappearTime;

    /**
     * <p>Reference to the scoreboard object.</p>
     */
    Scoreboard scoreboard;

    /**
     * <p>Boolean to check whether or not a player just entered a blackhole.</p>
     */
    boolean justTeleported = false;

    /**
     * <p>The cells on the map. Each containing information about the entity on it.</p>
     */
    Cell[][] cells;

    /**
     * <p>Reference to the player</p>
     */
    public Gameobject player;

    /**
     * <p>Reference to the enemies</p>
     */
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

    private List<GameEndListener> endListeners = new ArrayList<>();

    /**
     * Method to check for game end conditions.
     */
    public void checkForGameEnd() {
        // Check if the player has run out of oxygen
        if (oxygen <= 0) {
            notifyGameEndListeners(false); // End the game with a loss
        }
        // Check if the player has reached the end tile
        else if (player != null && getObject(player.Transform.gridX, player.Transform.gridY) instanceof EndTile) {
            notifyGameEndListeners(true); // End the game with a win
        }
    }

    /**
     * Method to notify game end listeners.
     * @param isWin true if the game ended with a win, false otherwise
     */
    private void notifyGameEndListeners(boolean isWin) {
        for (GameEndListener listener : endListeners) {
            listener.onGameEnd(isWin);
        }
    }

    /**
     * Method to add a game end listener.
     * @param listener the listener to be added
     */
    public void addGameEndListener(GameEndListener listener) {
        endListeners.add(listener);
    }
}