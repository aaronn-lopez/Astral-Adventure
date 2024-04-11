/**
 * <p>Player class, responsible for handling collision between itself, and other cells.</p>
 */
public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");

    }

    /**
     * <p>Check if the player is colliding with anything.</p>
     */
    public void checkCollisions(){

        Cell currentCell = GameManager.getCell(this.Transform.gridX, this.Transform.gridY);
        Gameobject hit = null;

        // there can be no collision if there is no cell for the collision to take place!
        if (currentCell == null)
        {
            return;
        }

        // check what the player hit
        if(currentCell.enemy != null){
            hit = currentCell.enemy;
        }
        else if(currentCell.interactable != null){
            hit = currentCell.interactable;
        }

        // handle the hit differently
        if(hit != null) {
            hit.onHit();
        }
    }

    /**
     * <p>Decreases oxygen, and handles logic for ending the game if the player runs out.</p>
     * @param rate the rate at which oxygen should be decreased by.
     */
    public void checkOxygen(int rate){
        GameManager.gameManager.oxygen -= rate;

        // end the game if the player's oxygen reaches below 0
        if(GameManager.gameManager.oxygen < 0)
        {
            GameManager.gameManager.oxygen = 0;
            GameManager.gameManager.score = (GameManager.gameManager.baseScore + GUIManager.guiManager.remainingOxygen) / GameManager.gameManager.elapsedTime;
            GUIManager.guiManager.gameEnd(false, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
        }
    }
}
