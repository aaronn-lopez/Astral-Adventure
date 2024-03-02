import processing.core.PApplet;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    Gameobject player;
    Gameobject battery;
    Gameobject blackhole;
    Gameobject oxygentank;

    Gameobject[][] cliffSprites;
    Gameobject[][] outlineSprites;
    Gameobject[][] pathSprites;

    int tileSize = 64;
    int numRows = 8;
    int numCols = 8;

    // Window settings
    @Override
    public void settings(){
        size(1280, 720);
    }

    // Stuff we want to do before we do the constant game update loop
    @Override
    public void setup() {
        // send static reference of the PApplet
        Gameobject.init(this);

        // Calculate the starting position for the grid to be centered
        int startX = (width - numCols * tileSize) / 2;
        int startY = (height - numRows * tileSize) / 2;

        // Example of drawing tiles
        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");
        player = new Gameobject(new Transform(500, 480, 0, 1), "src/main/Sprites/Astronaut.png");

        battery = new Battery(new Transform(550, 400, 0, 1));
        blackhole = new Blackhole(new Transform(600, 520, 0, 1), 1);
        oxygentank = new OxygenTank(new Transform(630, 440, 0, 1));

        // There are three sprites per 'ground' tile so that we get the cool 'layering' effect
        cliffSprites = new Gameobject[numRows][numCols];
        outlineSprites = new Gameobject[numRows][numCols];
        pathSprites = new Gameobject[numRows][numCols];

        String pathSprite = "src/main/Sprites/Path.png";
        String outlineSprite = "src/main/Sprites/Path Outline.png";
        String cliffSprite = "src/main/Sprites/Path Cliff.png";

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int x = startX + j * tileSize + tileSize / 2;
                int y = startY + i * tileSize + tileSize / 2;

                Transform transform = new Transform(x, y, 0, 1);

                cliffSprites[i][j] = new Gameobject(transform, cliffSprite);
                outlineSprites[i][j] = new Gameobject(transform, outlineSprite);
                pathSprites[i][j] = new Gameobject(transform, pathSprite);
            }
        }
    }

    // Called once every frame
    @Override
    public void draw(){
        bg.draw();

        // Need to draw each component separately to keep proper layer order
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                cliffSprites[i][j].draw();
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                outlineSprites[i][j].draw();
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                pathSprites[i][j].draw();
            }
        }

        player.draw();
        battery.draw();
        blackhole.draw();
        oxygentank.draw();
    }
}