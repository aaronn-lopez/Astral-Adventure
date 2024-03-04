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

    GameManager gameManager;

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
        gameManager = new GameManager();

        // Calculate the starting position for the grid to be centered
        int startX = (width - numCols * tileSize) / 2;
        int startY = (height - numRows * tileSize) / 2;

        gameManager.instantiate(Objects.Player, 0, 0);
        gameManager.instantiate(Objects.Battery, 4, 4);
        gameManager.instantiate(Objects.Blackhole, 7, 7);

        gameManager.instantiate(Objects.Blackhole, 0, 5);
        gameManager.instantiate(Objects.Blackhole, 1, 5);
        gameManager.instantiate(Objects.Blackhole, 2, 5);
        gameManager.instantiate(Objects.Blackhole, 3, 5);
        gameManager.instantiate(Objects.Blackhole, 4, 5);
        gameManager.instantiate(Objects.Blackhole, 5, 5);
        gameManager.instantiate(Objects.Blackhole, 6, 5);
        gameManager.instantiate(Objects.Blackhole, 7, 5);

        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");

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
        for(int pass = 0; pass < 3; pass++) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (!gameManager.cells[i][j].isEmpty) {
                        gameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(gameManager.cells[i][j].entity != null) {
                    gameManager.cells[i][j].entity.draw();
                }
            }
        }
    }
}