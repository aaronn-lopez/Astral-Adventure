import processing.core.PApplet;
import processing.core.PFont;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    GameManager gameManager = new GameManager();
    Map testingMap;
    Player player;

    PFont font;

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
        testingMap = new Map();
        testingMap.newMap("src/main/java/TestingMap1.txt");

        player = (Player)gameManager.player;

        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");

        font = createFont("src/main/Sprites/pixelFont.ttf", 32);
        textFont(font);
    }

    // Called once every frame
    @Override
    public void draw(){
        bg.draw();
        frameRate(40);

        for(int pass = 0; pass < 3; pass++) {
            for (int i = 0; i < gameManager.gridX; i++) {
                for (int j = 0; j < gameManager.gridY; j++) {
                    if (gameManager.cells[i][j].isEmpty) {
                        gameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        for(int i = 0; i < gameManager.gridX; i++){
            for(int j = 0; j < gameManager.gridY; j++){
                if (gameManager.cells[i][j].entity != null && gameManager.cells[i][j].isEmpty) {
                    gameManager.cells[i][j].entity.draw();
                }
            }
        }

        //Every frame checks the current oxygen and simultaneously reduces
        ((Player)gameManager.player).checkOxygen();
        gameManager.player.draw();
        ((Player)gameManager.player).checkCollisions();

        fill(255);
        textSize(32);
        text("Score: " + GameManager.gameManager.score, 1000, 50);
        text("Oxygen: " + (int)(((float)GameManager.gameManager.oxygen / 4000) * 100) + "%", 1000, 90);

        gameClock();
    }

    public void gameClock(){
        if(frameCount % gameManager.framesPerTick == 0){
            // code to be executed once every game tick
            for(int i = 0; i < gameManager.enemies.size(); i++){
                if(gameManager.enemies.get(i) instanceof WalkingAlien){
                    ((WalkingAlien)gameManager.enemies.get(i)).Patrol();
                }
            }
        }
    }

    @Override
    public void keyPressed(){
        switch(key){
            case 'w':
                player.move(Directions.Up);
                break;
            case 'd':
                player.move(Directions.Right);
                break;
            case 's':
                player.move(Directions.Down);
                break;
            case 'a':
                player.move(Directions.Left);
                break;
        }
    }
}