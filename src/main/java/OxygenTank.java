import processing.core.PApplet;

public class OxygenTank extends Collectable{
    OxygenTank(Transform transform){
        super(transform, "src/main/Sprites/OxygenTank.png");
    }

    public void draw(){
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