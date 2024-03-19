import processing.core.PApplet;

/**
 * <p>Collectable oxygen tank that raises the player's oxygen on collision.</p>
 */
public class OxygenTank extends Collectable{
    OxygenTank(Transform transform){
        super(transform, "src/main/Sprites/OxygenTank.png");
    }

    public void draw(){
        // remove the oxygen tank if a certain amount of time passes
        if(GameManager.gameManager.elapsedTime >= GameManager.gameManager.oxygenTankDisappearTime){
            GameManager.getCell(this.Transform.gridX, this.Transform.gridY).interactable = null;
        }

        super.draw();
    }

    @Override
    public void collect() {
        //if your oxygen is above 75% then there will be "overflow"
        if(GameManager.gameManager.oxygen > 1000)
        {
            //add to score by bonus "overflow"
            GameManager.gameManager.baseScore += (int) ((double) (GameManager.gameManager.oxygen - 1000) /40);
        }
        //Reduced the oxygen tank replenish amount to 25% as 75%  was too much
        GameManager.gameManager.oxygen = PApplet.min(4000, GameManager.gameManager.oxygen + 1000);
    }
}