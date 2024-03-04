import java.util.ArrayList;

public class GameManager {
    int tickSpeed;
    int score;

    int gridX = 8;
    int gridY = 8;

    Scoreboard scoreboard;

    ArrayList<Gameobject> gameobjects;
    Cell[][] cells;

    GameManager(){
        cells = new Cell[gridX][gridY];

        for(int i = 0; i < gridX; i++){
            for(int j = 0; j < gridY; j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    void instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        switch(object){
            case Objects.Player:
                cells[x][y].entity = new Player(new Transform(x * 64, y * 64, 0, 1));
                break;
            case Objects.WalkingAlien:
                cells[x][y].entity = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
                break;
            case Objects.HidingAlien:
                cells[x][y].entity = new HidingAlien(new Transform(x * 64, y * 64, 0, 1));
                break;
            case Objects.OxygenTank:
                cells[x][y].entity = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
                break;
            case Objects.Battery:
                cells[x][y].entity = new Battery(new Transform(x * 64, y * 64, 0, 1));
                break;
            case Objects.Blackhole:
                cells[x][y].entity = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
                break;
            default:
                return;
        }
    }
}
