import java.util.ArrayList;

public class GameManager {
    int tickSpeed;
    int score;

    static int gridX = 8;
    static int gridY = 8;

    Scoreboard scoreboard;

    ArrayList<Gameobject> gameobjects;
    static Cell[][] cells;

    GameManager(){

    }

    static void updateMap(Map map){

    }

    public static Gameobject instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        Gameobject gameobject = null;
        switch(object){
            case Objects.Player:
                gameobject = new Player(new Transform(x * 64, y * 64, 0, 1));
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            case Objects.WalkingAlien:
                gameobject = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            case Objects.HidingAlien:
                gameobject = new HidingAlien(new Transform(x * 64, y * 64, 0, 1));
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            case Objects.OxygenTank:
                gameobject = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            case Objects.Battery:
                gameobject = new Battery(new Transform(x * 64, y * 64, 0, 1));
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            case Objects.Blackhole:
                gameobject = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                cells[x][y].entity = gameobject;
                cells[x][y].entity.Transform.gridX = x;
                cells[x][y].entity.Transform.gridY = y;
                break;
            default:
                break;
        }
        return gameobject;
    }
}
