import processing.core.PConstants;

import static processing.core.PApplet.sin;

public abstract class Character extends Gameobject{

    Character(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    void move(){};
}
