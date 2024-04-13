package Game;

import processing.core.PApplet;

/**
 * <p>Collectable oxygen tank that raises the player's oxygen on collision.</p>
 */
public class OxygenTank extends Collectable{
    private static final int OXYGEN_POINTS_MAX = 4000;
    private static final int OXYGEN_POINTS_75 = 3000;
    private static final int OXYGEN_POINTS_25 = 1000;
    private static final int OXYGEN_CONVERSION_RATIO = 40;
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
        if(GameManager.gameManager.currentOxygen > OXYGEN_POINTS_75)
        {
            //add to score by bonus "overflow"
            GameManager.gameManager.baseScore += (int) ((double) (GameManager.gameManager.currentOxygen - OXYGEN_POINTS_75)/OXYGEN_CONVERSION_RATIO);
        }
        //Reduced the oxygen tank replenish amount to 25% as 75%  was too much
        GameManager.gameManager.currentOxygen = PApplet.min(OXYGEN_POINTS_MAX, GameManager.gameManager.currentOxygen + OXYGEN_POINTS_25);
    }
}