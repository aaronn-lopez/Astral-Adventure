import java.util.ArrayList;

public class GameManager {
    static GameManager gameManager;
    int framesPerTick = 40;
    int score = 0;
    int completionCount = 0;

    int totalBatteries = 0;
    int oxygen = 4000;
    int oxygenRate = 1;
    int gridX = 8;
    int gridY = 8;

    Scoreboard scoreboard;

    boolean justTeleported = false;

    ArrayList<Gameobject> gameobjects;
    Cell[][] cells;

    public Gameobject player;
    public ArrayList<Gameobject> enemies;

    GameManager(){
        gameManager = this;
        gameManager.enemies = new ArrayList<Gameobject>();
    }

    public static Gameobject instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        Gameobject gameobject = null;
        switch(object){
            case Player:
                gameobject = new Player(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].player = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                gameManager.player = gameobject;
                break;
            case WalkingAlien:
                gameobject = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                gameManager.enemies.add(gameobject);
                break;
            case HidingAlien:
                gameobject = new Spike(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                gameManager.enemies.add(gameobject);
                break;
            case OxygenTank:
                gameobject = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case Battery:
                gameobject = new Battery(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case Blackhole:
                gameobject = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case EndTile:
                gameobject = new EndTile(new Transform(x * 64, y * 64, 0, 1), 0);
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            default:
                break;
        }
        return gameobject;
    }
}