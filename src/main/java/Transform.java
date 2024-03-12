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
    Transform(float x, float y, float rot, float scale){
        this.x = x;
        this.y = y;

        this.rotation = rot;
        this.scale = scale;
    }

    Transform(){
        this.x = 0;
        this.y = 0;

        this.rotation = 0;
        this.scale = 1;
    }
}
