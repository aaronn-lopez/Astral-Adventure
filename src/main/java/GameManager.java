import java.util.ArrayList;

public class GameManager {
    int tickSpeed;
    int score;

    Scoreboard scoreboard;

    ArrayList<Gameobject> gameobjects;
    Cell[][] cells;

    void instantiate(Objects object, int x, int y){
        // instantiate an object at a given x, y coordinate
        switch(object){
            case Player:
            case WalkingAlien:
            case HidingAlien:
            case OxygenTank:
            case Battery:
            case Blackhole:
        }
    }
}
