import processing.core.PApplet;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");

    }

    public void checkCollisions(){
        Cell currentCell = GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY];
        if(currentCell.entity != null){
            Gameobject hit = currentCell.entity;
            if(hit instanceof WalkingAlien || hit instanceof Spike){
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
                ((Blackhole) hit).teleport();
            }
            else if(hit instanceof Battery){
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
                currentCell.entity = null;
            }
            else if(hit instanceof EndTile){
                if(GameManager.gameManager.totalBatteries == GameManager.gameManager.completionCount)
                {
                    GameManager.gameManager.score -= GameManager.gameManager.elapsedTime * 2;
                    GUIManager.guiManager.gameEnd(true, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
                }
            }
        }
    }


    //Decreases at an accurate frame-to-second ratio
    //giving the player an initial 60 seconds before they run out of oxygen.
    public void checkOxygen(int rate){
        GameManager.gameManager.oxygen -= rate;
        if(GameManager.gameManager.oxygen < 0)
        {
            GameManager.gameManager.oxygen = 0;
            GUIManager.guiManager.gameEnd(false, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
        }
    }
}
