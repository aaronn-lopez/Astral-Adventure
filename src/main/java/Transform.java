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

    // Constructor
    Transform(float x, float y, float rot, float scale){
        this.x = x;
        this.y = y;

        this.gridX = (int)x;
        this.gridY = (int)y;

        this.rotation = rot;
        this.scale = scale;
    }
}
