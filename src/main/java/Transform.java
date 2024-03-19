/**
 * <p>Base class for an object's position, rotation, and scale.</p>
 */
public class Transform {
    // Floating point position -> for smooth movements
    float x;
    float y;

    // Integer grid-based position -> easier collision checks
    int gridX;
    int gridY;

    // Optional rotation and scale parameters if needed
    float rotation;
    float scale;

    // Optional position offset parameters
    public float offsetX = 0;
    public float offsetY = 0;

    // Constructor

    /**
     * <p>Create a new transform</p>
     * @param x x position
     * @param y y position
     * @param rot rotation
     * @param scale scale
     */
    Transform(float x, float y, float rot, float scale){
        this.x = x;
        this.y = y;

        this.rotation = rot;
        this.scale = scale;
    }
}
