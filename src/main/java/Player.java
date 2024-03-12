import processing.core.PConstants;

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
            }
            else if(hit instanceof Blackhole){
                println("Hit blackhole!");
                ((Blackhole) hit).teleport();
            }
            else if(hit instanceof Battery){
                println("Hit battery!");
            }
            else if(hit instanceof OxygenTank){
                println("Hit oxygen tank!");
            }
        }
    }

}
