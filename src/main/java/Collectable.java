import processing.core.PConstants;

import static processing.core.PApplet.sin;

/**
 * <p>Abstract class for anything collectable by the player, such as a battery, or oxygen tank.</p>
 */
public abstract class Collectable extends Mapobject{
    Collectable(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    public void draw(){
        // move the collectable in an oscillating up and down pattern
        this.Transform.offsetY += (float) (-sin((float) p.frameCount / 10) * 1.1);

        // add a shadow
        p.fill(0, 0, 0,100);
        p.noStroke();
        p.ellipseMode(PConstants.CENTER);
        p.ellipse(this.Transform.x, this.Transform.y, 48, 32);

        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x + this.Transform.offsetX, this.Transform.y + this.Transform.offsetY);
    }

    /**
     * <p>Function to be called on collision with the player.</p>
     */
    public abstract void collect();
}
