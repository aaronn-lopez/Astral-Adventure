import processing.core.PApplet;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");

    }

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
