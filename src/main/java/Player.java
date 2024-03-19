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

        if(currentCell.enemy != null){
            hit = currentCell.enemy;
        }
        else if(currentCell.interactable != null){
            hit = currentCell.interactable;
        }

        if(hit != null) {
            switch (hit) {
                case Enemy enemy -> {
                    enemy.decreaseOxygen();
                    currentCell.enemy = null;
                    GameManager.gameManager.enemies.remove(hit);
                }
                case Blackhole blackhole -> blackhole.teleport();
                case Collectable collectable -> {
                    collectable.collect();
                    currentCell.interactable = null;
                }
                case EndTile endTile -> endTile.gameEndCheck();
                default -> {
                }
            }
        }
    }

    /**
     * <p>Decreases oxygen, and handles logic for ending the game if the player runs out.</p>
     * @param rate the rate at which oxygen should be decreased by.
     */
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
