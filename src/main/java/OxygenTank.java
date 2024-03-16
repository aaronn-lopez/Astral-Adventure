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
            GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY].entity = null;
        }


        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x + this.Transform.offsetX, this.Transform.y + this.Transform.offsetY);
    }
}