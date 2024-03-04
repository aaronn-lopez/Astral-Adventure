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
    }

    // Called once every frame
    @Override
    public void draw(){
        bg.draw();

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