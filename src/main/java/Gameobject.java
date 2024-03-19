import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PApplet;

/**
 * <p>Parent Class containing basic information about every object in the game.</p>
 */
public class Gameobject {
    // Reference to the "canvas"---where we are drawing the sprites
    protected static PApplet p;

    // Class to hold the position, rotation, and scale of the gameobject
    public Transform Transform;

    // The actual sprite to be drawn to the canvas
    public PImage Sprite;

    // Call this during setup to properly assign the canvas, so we know where to draw

    /**
     * <p>Initialize the canvas so the gameobject knows where to draw.</p>
     * @param app reference to the PApplet
     */
    public static void init(PApplet app){
        p = app;
    }

    // Constructor; requires a transform, and a string containing a path to the image.
    Gameobject(Transform transform, String spritePath){
        this.Transform = transform;
        this.Sprite = p.loadImage(spritePath);
        if(this instanceof Character || this instanceof Blackhole || this instanceof EndTile || this instanceof Collectable){
            this.Transform.offsetY = -32;
        }
    }

    /**
     * <p>Updates the position of the gameobject</p>
     * @param x grid X position
     * @param y grid Y position
     */
    public void setPosition(int x, int y){
        Transform.gridX = x;
        Transform.gridY = y;
        Transform.x = Transform.gridX * 64;
        Transform.y = Transform.gridY * 64;
    }

    /**
     * <p>Main method for drawing gameobjects to the screen, using it's position and scale.</p>
     */
    public void draw(){
        if(this instanceof WalkingAlien || this instanceof Blackhole || this instanceof EndTile || this instanceof Collectable || this instanceof Player){
            p.fill(0, 0, 0,100);
            p.noStroke();
            p.ellipseMode(PConstants.CENTER);
            p.ellipse(this.Transform.x, this.Transform.y, 48, 32);
        }

        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x + this.Transform.offsetX, this.Transform.y + this.Transform.offsetY, Sprite.width * this.Transform.scale, Sprite.height * this.Transform.scale);
    }
}
