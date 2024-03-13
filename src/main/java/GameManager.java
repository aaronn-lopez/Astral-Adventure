import java.util.ArrayList;

public class GameManager {
    static GameManager gameManager;
    int tickSpeed;
    int score = 0;
    int completionCount = 0;
    int oxygen = 4000;

    int gridX = 8;
    int gridY = 8;

    Scoreboard scoreboard;

    boolean justTeleported = false;

    ArrayList<Gameobject> gameobjects;
    Cell[][] cells;

    public Gameobject player;

    GameManager(){
        gameManager = this;
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
                gameManager.cells[x][y].entities.add(gameobject);
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case HidingAlien:
                gameobject = new HidingAlien(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entities.add(gameobject);
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case OxygenTank:
                gameobject = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entities.add(gameobject);
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case Battery:
                gameobject = new Battery(new Transform(x * 64, y * 64, 0, 1));
                gameManager.cells[x][y].entities.add(gameobject);
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            case Blackhole:
                gameobject = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                gameManager.cells[x][y].entities.add(gameobject);
                gameobject.Transform.gridX = x;
                gameobject.Transform.gridY = y;
                break;
            default:
                break;
        }
        return gameobject;
    }
}