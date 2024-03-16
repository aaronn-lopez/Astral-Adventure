import java.util.ArrayList;

public class GameManager {
    static GameManager gameManager;
    int framesPerTick = 40;
    int score = 0;
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
                gameobject = new EndTile(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entity = gameobject;
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            default:
                break;
        }
        return gameobject;
    }

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
}