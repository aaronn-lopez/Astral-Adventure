import processing.core.PConstants;

import static processing.core.PApplet.println;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");
        println(Transform.gridX, Transform.gridY);
    }

    public void draw(){
        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }

}
