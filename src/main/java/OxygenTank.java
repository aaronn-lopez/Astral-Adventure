import processing.core.PApplet;
import processing.core.PConstants;
import static processing.core.PApplet.sin;

public class OxygenTank extends Collectable{
    OxygenTank(Transform transform){
        super(transform, "src/main/Sprites/OxygenTank.png");
    }

    public void draw(){
        this.Transform.offsetY += (float) (-sin((float) p.frameCount / 10) * 1.1);

        p.fill(0, 0, 0,100);
        p.noStroke();
        p.ellipseMode(PConstants.CENTER);
        p.ellipse(this.Transform.x, this.Transform.y, 48, 32);

        if(GameManager.gameManager.elapsedTime >= GameManager.gameManager.oxygenTankDisappearTime)
        {
            GameManager.getCell(this.Transform.gridX, this.Transform.gridY).interactable = null;
        }


        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x + this.Transform.offsetX, this.Transform.y + this.Transform.offsetY);
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