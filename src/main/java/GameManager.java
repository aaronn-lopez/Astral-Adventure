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
            case Player:
                cells[x][y].entity = new Player(new Transform(x * 64, y * 64, 0, 1));
            case WalkingAlien:
                cells[x][y].entity = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
            case HidingAlien:
                cells[x][y].entity = new HidingAlien(new Transform(x * 64, y * 64, 0, 1));
            case OxygenTank:
                cells[x][y].entity = new OxygenTank(new Transform(x * 64, y * 64, 0, 1));
            case Battery:
                cells[x][y].entity = new Battery(new Transform(x * 64, y * 64, 0, 1));
            case Blackhole:
                cells[x][y].entity = new Blackhole(new Transform(x * 64, y * 64, 0, 1), 0);
        }
    }
}
