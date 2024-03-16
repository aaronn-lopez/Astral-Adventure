import processing.core.PApplet;
import processing.core.PFont;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    GameManager gameManager = new GameManager();
    GUIManager guiManager = new GUIManager(this);

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

        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");

        font = createFont("src/main/Sprites/pixelFont.ttf", 32);
        textFont(font);
    }

    public void gameUpdate(){
        bg.draw();

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
        ((Player)gameManager.player).checkOxygen(gameManager.oxygenRate);
        gameManager.player.draw();
        ((Player)gameManager.player).checkCollisions();

        gameClock();
    }

    // Called once every frame
    @Override
    public void draw(){
        frameRate(40);

        switch(guiManager.state){
            case GUIState.Game:
                gameUpdate();
                guiManager.gameGUI();
                break;
            case GUIState.Pause:
                guiManager.pause();
                break;
            case GUIState.Start:
                guiManager.startScreen();
                break;
            case GUIState.End:
                guiManager.endingScreen();
                break;
            case GUIState.Scoreboard:
                guiManager.scoreboardScreen();
                break;
            case GUIState.Help:
                guiManager.helpScreen();
                break;
            case GUIState.DifficultySelect:
                guiManager.difficultyScreen();
                break;
            case GUIState.Controls:
                guiManager.controlsScreen();
                break;
            default:
                break;
        }


    }

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
        if(guiManager.state == GUIState.Game) {
            switch (key) {
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

        if(key == ESC){
            key = 0;
            if (guiManager.state == GUIState.Game)
                guiManager.pause();
            else if (guiManager.state == GUIState.Pause)
                guiManager.resume();
        }
    }
}