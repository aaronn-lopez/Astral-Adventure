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
                if(hit instanceof Spike){
                    ((Spike) hit).decreaseOxygen();
                }
                if(hit instanceof WalkingAlien){
                    ((WalkingAlien) hit).decreaseOxygen();
                }
                currentCell.entity = null;
                GameManager.gameManager.enemies.remove(hit);
            }
            else if(hit instanceof Blackhole){
                ((Blackhole) hit).teleport();
            }
            else if(hit instanceof Battery){
                ((Battery) hit).collect();
                currentCell.entity = null;
            }
            else if(hit instanceof OxygenTank){
                ((OxygenTank) hit).collect();
                currentCell.entity = null;
            }
            else if(hit instanceof EndTile){
                ((EndTile) hit).gameEndCheck();
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
            GameManager.gameManager.score = (GameManager.gameManager.baseScore + GUIManager.guiManager.remainingOxygen) / GameManager.gameManager.elapsedTime;
            GUIManager.guiManager.gameEnd(false, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
        }
    }
}
