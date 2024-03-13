import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.max;
import static processing.core.PApplet.println;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");

    }

    public void checkCollisions(){
        Cell currentCell = GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY];
        if(!currentCell.entities.isEmpty()){
            Gameobject hit = currentCell.entities.getFirst();
            if(hit instanceof WalkingAlien || hit instanceof HidingAlien){
                println("Hit enemy!");
                currentCell.entities.remove(hit);
            }
            else if(hit instanceof Blackhole){
                println("Hit blackhole!");
                ((Blackhole) hit).teleport();
            }
            else if(hit instanceof Battery){
                println("Hit battery!");
                GameManager.gameManager.completionCount++;
                currentCell.entities.remove(hit);
            }
            else if(hit instanceof OxygenTank){
                println("Hit oxygen tank!");
                GameManager.gameManager.oxygen = PApplet.min(2400, GameManager.gameManager.oxygen + 1600);
                currentCell.entities.remove(hit);
            }
        }
    }

    public void checkOxygen(){
        GameManager.gameManager.oxygen -= 1;
        println(GameManager.gameManager.oxygen);
        if(GameManager.gameManager.oxygen < 0)
        {
            println("Oxygen ran out you lose");
            System.exit(0);
        }
    }

}
