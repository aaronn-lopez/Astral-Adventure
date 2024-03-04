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
                cells[i][j] = new Cell();
            }
        }
    }

    void instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        switch(object){
            case Player:
                cells[x][y].entity = new Player(new Transform());
            case WalkingAlien:
                cells[x][y].entity = new WalkingAlien(new Transform());
            case HidingAlien:
                cells[x][y].entity = new HidingAlien(new Transform());
            case OxygenTank:
                cells[x][y].entity = new OxygenTank(new Transform());
            case Battery:
                cells[x][y].entity = new Battery(new Transform());
            case Blackhole:
                cells[x][y].entity = new Blackhole(new Transform(), 0);
        }
    }
}
