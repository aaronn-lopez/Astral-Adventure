package Game;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Singleton. Contains a majority of the internal information about the current game state.</p>
 */
public class GameManager {
    public static GameManager gameManager;

    /**
     * <p>The amount of frames per game clock tick.</p>
     */
    public int framesPerTick = 40;

    /**
     * <p>The player's current, final score.</p>
     */
    public int finalScore = 0;

    /**
     * <p>The player's score before additional calculations for extra oxygen, and time elapsed.</p>
     */
    public int baseScore = 0;

    /**
     * <p>The player's current amount of collected batteries.</p>
     */
    public int collectedBatteries = 0;

    /**
     * <p>The total amount of batteries in the current level.</p>
     */
    public int totalBatteries = 0;

    /**
     * <p>The player's current oxygen levels.</p>
     */
    public int currentOxygen = 4000;

    /**
     * <p>The player's maximum oxygen.</p>
     */
    public int maxOxygen = 4000;

    /**
     * <p>The rate at which oxygen is decreased in the current level.</p>
     */
    public int oxygenDecreaseRate = 1;

    /**
     * <p>The x dimension of the game board.</p>
     */
    public int gridX = 8;

    /**
     * <p>The y dimension of the game board.</p>
     */
    public int gridY = 8;

    /**
     * <p>The amount of time elapsed since starting the level.</p>
     */
    public int elapsedTime = 0;

    /**
     * <p>The current level number</p>
     */
    public int level;

    /**
     * <p>The amount of time that should pass before the oxygen tanks disappear.</p>
     */
    public int oxygenTankDisappearTime;

    /**
     * <p>Reference to the scoreboard object.</p>
     */
    public Scoreboard scoreboard;

    /**
     * <p>Boolean to check whether or not a player just entered a blackhole.</p>
     */
    boolean justTeleported = false;

    /**
     * <p>The cells on the map. Each containing information about the entity on it.</p>
     */
    public Cell[][] cells;

    /**
     * <p>Reference to the player</p>
     */
    public Gameobject player;

    /**
     * <p>Reference to the enemies</p>
     */
    public ArrayList<Gameobject> enemies;

    public GameManager(){
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
            case Objects.Player:
                gameobject = new Player(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].player = gameobject;
                gameobject.setPosition(x, y);
                gameManager.player = gameobject;
                break;
            case Objects.WalkingAlien:
                gameobject = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).enemy = gameobject;
                gameobject.setPosition(x, y);
                gameManager.enemies.add(gameobject);
                break;
            case Objects.HidingAlien:
                gameobject = new Spike(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).enemy = gameobject;
                gameobject.setPosition(x, y);
                gameManager.enemies.add(gameobject);
                break;
            case Objects.OxygenTank:
                gameobject = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case Objects.Battery:
                gameobject = new Battery(new Transform(x * 64, y * 64, 0, 1));
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case Objects.Blackhole:
                gameobject = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                getCell(x, y).interactable = gameobject;
                gameobject.setPosition(x, y);
                break;
            case Objects.EndTile:
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
        gameManager.finalScore = 0;
        gameManager.enemies.clear();
        gameManager.collectedBatteries = 0;
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
                gameManager.currentOxygen = 4000;
                gameManager.oxygenDecreaseRate = 1;
                gameManager.oxygenTankDisappearTime = 45;
                break;
            case 2:
                gameManager.currentOxygen = 3500;
                gameManager.oxygenDecreaseRate = 1;
                gameManager.oxygenTankDisappearTime = 30;
                break;
            case 3:
                gameManager.currentOxygen = 3000;
                gameManager.oxygenDecreaseRate = 1;
                gameManager.oxygenTankDisappearTime = 20;
                break;
            case 4:
                gameManager.currentOxygen = 2500;
                gameManager.oxygenDecreaseRate = 2;
                gameManager.oxygenTankDisappearTime = 20;
                break;
            case 5:
                gameManager.currentOxygen = 2000;
                gameManager.oxygenDecreaseRate = 2;
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
        if (gameManager.cells == null) {
            return null;
        }
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
        if (currentOxygen <= 0) {
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