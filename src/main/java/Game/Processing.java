package Game;

import GUI.GUIManager;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * <p>Program game loop. Where the game is updated every game tick.</p>
 */
public class Processing extends PApplet {
    Gameobject bg;
    public GameManager gameManager = new GameManager();
    public GUIManager guiManager = new GUIManager(this);

    static public Player player;

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

        // Create a backdrop
        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");

        font = createFont("src/main/Sprites/pixelFont.ttf", 32);
        textFont(font);
    }

    /**
     * <p>Called once every frame to handle the game logic.</p>
     */
    public void gameUpdate(){
        bg.draw();

        // draw tiles in 3 separate passes
        for(int pass = 0; pass < 3; pass++) {
            for (int i = 0; i < gameManager.gridX; i++) {
                for (int j = 0; j < gameManager.gridY; j++) {
                    if (gameManager.cells[i][j].isEmpty) {
                        gameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        // draw the entities
        for(int i = 0; i < gameManager.gridX; i++){
            for(int j = 0; j < gameManager.gridY; j++){
                if (GameManager.getEnemy(i, j)!= null && GameManager.getCell(i, j).isEmpty) {
                    GameManager.getEnemy(i, j).draw();
                }

                if(GameManager.getObject(i, j) != null && GameManager.getCell(i, j).isEmpty){
                    GameManager.getObject(i, j).draw();
                }
            }
        }

        //Every frame checks the current oxygen and simultaneously reduces
        ((Player)gameManager.player).checkOxygen(gameManager.oxygenRate);
        ((Player)gameManager.player).checkCollisions();
        gameManager.player.draw();

        gameClock();
    }

    // Called once every frame
    @Override
    public void draw(){
        frameRate(40);
        if(guiManager.currentScreen == guiManager.gameScreen)
            gameUpdate();
        guiManager.currentScreen.display();
    }


    /**
     * <p>Called once every game tick to handle enemy patrol.</p>
     */
    public void gameClock(){
        if(frameCount % gameManager.framesPerTick == 0){
            // code to be executed once every game tick
            gameManager.elapsedTime++;
            for(int i = 0; i < gameManager.enemies.size(); i++){
                if(gameManager.enemies.get(i) instanceof WalkingAlien){
                    ((WalkingAlien)gameManager.enemies.get(i)).Patrol();
                }
            }
        }
    }

    @Override
    public void keyPressed(){
        if(guiManager.currentScreen == guiManager.gameScreen){
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

        // Toggle pause
        if(key == ESC){
            key = 0;

            if(guiManager.currentScreen == guiManager.gameScreen)
                guiManager.currentScreen = guiManager.pauseScreen;
            else if(guiManager.currentScreen == guiManager.pauseScreen)
                guiManager.resume();
        }
    }
}