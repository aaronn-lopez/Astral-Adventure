import processing.core.PConstants;

import static processing.core.PApplet.sin;

public abstract class Character extends Gameobject{

    Character(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    void move(){
    };

    // First implementation of the character moving when user presses w,s,a,d
    public void draw(){
        if(p.keyPressed){
            if(p.key == 'w' || p.key == 'W')
            {
                this.Transform.y -= 1;
            }
            else if(p.key == 'a' || p.key == 'A')
            {
                this.Transform.x -= 1;
            }
            else if(p.key == 's' || p.key == 'S')
            {
                this.Transform.y += 1;
            }
            else if(p.key == 'd' || p.key == 'D') {
                this.Transform.x += 1;
            }
        }
        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }
}
