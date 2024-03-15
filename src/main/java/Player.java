import processing.core.PApplet;

import static processing.core.PApplet.max;
import static processing.core.PApplet.println;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");

    }

    public void checkCollisions(){
        Cell currentCell = GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY];
        if(currentCell.entity != null){
            Gameobject hit = currentCell.entity;
            if(hit instanceof WalkingAlien || hit instanceof Spike){
                println("Hit enemy!");
                //if you hit a spike you lose 5 seconds worth of oxygen
                if(hit instanceof Spike){
                    GameManager.gameManager.oxygen -= 480;
                }
                if(hit instanceof WalkingAlien){
                    GameManager.gameManager.oxygen -= 480 * 4;
                }
                currentCell.entity = null;
                GameManager.gameManager.enemies.remove(hit);
            }
            else if(hit instanceof Blackhole){
                println("Hit blackhole!");
                ((Blackhole) hit).teleport();
            }
            else if(hit instanceof Battery){
                println("Hit battery!");
                GameManager.gameManager.score += 100;
                GameManager.gameManager.completionCount++;
                currentCell.entity = null;
            }
            else if(hit instanceof OxygenTank){
                //if your oxygen is above half then there will be "overflow"
                if(GameManager.gameManager.oxygen > 1000)
                {
                    //multiply score by bonus "overflow"
                    GameManager.gameManager.score *= (int) ((double) (GameManager.gameManager.oxygen - 1000) /40);
                }
                //nerfed the oxygen tank replenish amount to 25 as 75 points was overtuned
                GameManager.gameManager.oxygen = PApplet.min(4000, GameManager.gameManager.oxygen + 1000);
                println("Hit oxygen tank!");
                println(GameManager.gameManager.score);
                currentCell.entity = null;
            }
            else if(hit instanceof EndTile){
                println("Hit end tile!");
                if(GameManager.gameManager.totalBatteries == GameManager.gameManager.completionCount)
                {
                    println("Collected all batteries and hit end tile. You win!");
                    println("Calculating your final score: ");
                    GameManager.gameManager.score -= GameManager.gameManager.elapsedTime * 2;
                    println(GameManager.gameManager.score);
                    System.exit(0);
                }
                else
                {
                    println("You didn't collect all the batteries, go back and get them!");
                }
            }
        }
    }


    //Decreases at an accurate frame-to-second ratio
    //giving the player an initial 60 seconds before they run out of oxygen.
    public void checkOxygen(int rate){
        GameManager.gameManager.oxygen -= rate;
        println(GameManager.gameManager.oxygen);
        if(GameManager.gameManager.oxygen < 0)
        {
            println("Oxygen ran out you lose");
            println(GameManager.gameManager.score);
            System.exit(0);
        }
    }
}
