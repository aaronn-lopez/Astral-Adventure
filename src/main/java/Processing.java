import processing.core.PApplet;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    GameManager gameManager;
    Map testingMap;

    int numRows = 16;
    int numCols = 10;

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
        testingMap = new Map(16, 10);

        gameManager.updateMap(testingMap);


        gameManager.instantiate(Objects.Player, 3, 3);
        gameManager.instantiate(Objects.Battery, 4, 4);
        gameManager.instantiate(Objects.Blackhole, 7, 7);


        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");
    }

    // Called once every frame
    @Override
    public void draw(){
        bg.draw();

        for(int pass = 0; pass < 3; pass++) {
            for (int i = 2; i < numRows; i++) {
                for (int j = 2; j < numCols; j++) {
                    gameManager.cells[i][j].isEmpty = true;
                    if (gameManager.cells[i][j].isEmpty) {
                        gameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(gameManager.cells[i][j].entity != null && gameManager.cells[i][j].isEmpty) {
                    gameManager.cells[i][j].entity.draw();
                }
            }
        }
    }
}