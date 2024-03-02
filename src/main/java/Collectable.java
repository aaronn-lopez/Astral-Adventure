import processing.core.PConstants;

import static processing.core.PApplet.sin;

public abstract class Collectable extends Mapobject{
    int points;

    Collectable(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    abstract void collect();

    public void draw(){
        this.Transform.y += (float) (sin((float) p.frameCount / 10) * 1.1);

        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }
}
