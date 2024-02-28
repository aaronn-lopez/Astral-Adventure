import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PApplet;

/**
 * <p>Parent Class containing basic information about every object in the game.</p>
 */
public class Gameobject {
    // Reference to the "canvas"---where we are drawing the sprites
    private static PApplet p;

    // Class to hold the position, rotation, and scale of the gameobject
    public Transform Transform;

    // The actual sprite to be drawn to the canvas
    public PImage Sprite;

    // Call this during setup to properly assign the canvas, so we know where to draw
    public static void init(PApplet app){
        p = app;
    }

    // Constructor; requires a transform, and a string containing a path to the image.
    // TODO: default path containing blank image
    Gameobject(Transform transform, String spritePath){
        this.Transform = transform;
        this.Sprite = p.loadImage(spritePath);
    }

    Transform getTransform(){
        return this.Transform;
    }

    // Call this every frame to draw the gameobject using its current position
    public void draw(){
        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }
}
