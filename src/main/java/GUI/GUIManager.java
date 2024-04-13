package GUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PFont;
import Game.*;

import static processing.core.PConstants.*;

/**
 * <p>Singleton. Allows for the transition of game states through GUI buttons.</p>
 */

public class GUIManager {
    //public GUIState state = GUIState.Start;

    public GUIScreen gameScreen = new GameScreen();
    public GUIScreen pauseScreen = new PauseScreen();
    public GUIScreen startScreen = new StartScreen();
    public GUIScreen endScreen = new EndScreen();
    public GUIScreen scoreboardScreen = new ScoreboardScreen();
    public GUIScreen helpScreen = new HelpScreen();
    public GUIScreen difficultyScreen = new DifficultyScreen();
    public GUIScreen controlsScreen = new ControlsScreen();
    public GUIScreen currentScreen = startScreen;

    public static GUIManager  guiManager;
    public static GameManager gameManager;
    PApplet p;

    Button startButton;
    Button instructionsButton;
    Button backButton;
    Button leaderboardButton;
    Button mainMenuButton;
    Button playAgainButton;
    Button exitToMainMenuButton;
    Button[] levels;
    Button controlsButton;
    Button restartLvButton;

    private static final int OXYGEN_CONVERSION_RATIO = 40;

    public boolean won;
    public int score;
    public int remainingOxygen;
    public int totalTime;


    public GUIManager(PApplet p){
        guiManager = this;
        gameManager = GameManager.gameManager;
        this.p = p;

        GUIScreen.init(p, this);


        startButton = new Button(1280 / 2, 720 / 2 + 150, 300, 70, "Start Game", p.color(255, 100));
        instructionsButton = new Button(1280 / 2 + 160, 720 / 2 + 250, 300, 70, "Instructions", p.color(255, 100));
        controlsButton = new Button(1280 / 2 - 160 , 720 / 2 + 250 , 300, 70, "Controls", p.color(255, 100));
        backButton = new Button(60, 60, 100, 70, "Back", p.color(255, 100));
        leaderboardButton = new Button(1100, 60, 300, 70, "Leaderboard", p.color(255, 100));
        mainMenuButton = new Button(1280 / 2, 720 / 2 + 190, 300, 75, "Main Menu", p.color(255, 100));
        restartLvButton = new Button(1280 / 2, 720 / 2 + 105, 400, 75, "Restart Level", p.color(255, 100));

        levels = new Button[5];
        levels[0] = new Button(1280 / 2, 720 / 2 - 68, 325, 50, "1-Easy", p.color(255, 100));
        levels[1] = new Button(1280 / 2, 720 / 2, 325, 50, "2-Normal", p.color(255, 100));
        levels[2] = new Button(1280 / 2, 720 / 2 + 68, 325, 50, "3-Intermediate", p.color(255, 100));
        levels[3] = new Button(1280 / 2, 720 / 2 + 136, 325, 50, "4-Hard", p.color(255, 100));
        levels[4] = new Button(1280 / 2, 720 / 2 + 204, 325, 50, "5-Very Hard", p.color(255, 100));

        playAgainButton = new Button(1280 / 2 - 200, 720 / 2 + 125, 270, 70, "Play Again?", p.color(255, 100));
        exitToMainMenuButton = new Button(1280 / 2 + 200, 720 / 2 + 125, 240, 70, "Main Menu", p.color(255, 100));
    }

    /**
     * <p>Button class, for interactive GUI</p>
     */
    class Button {
        float x;
        float y;
        float w;
        float h;
        int color;
        String text;

        boolean isHovered;

        /**
         * <p>Button constructor.</p>
         * @param x screen x position
         * @param y screen y position
         * @param w button width
         * @param h button height
         * @param text button text
         * @param color button color
         */
        Button(float x, float y, float w, float h, String text, int color){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;

            this.text = text;
            this.color = color;
        }

        /**
         * <p>Displays the button to the screen</p>
         */
        void draw(){
            p.noStroke();
            p.rectMode(PConstants.CENTER);
            p.textAlign(PConstants.CENTER, PConstants.CENTER);
            p.textSize(40);

            p.fill(color);
            if(isHovered)
                p.rect(x, y, (float) (w * 1.1), (float) (h * 1.1), 50);
            else
                p.rect(x, y, w, h, 50);

            p.fill(255);
            p.text(text, x, y);
        }

        /**
         * <p>Check if the mouse is has clicked the button, or is hovering over it.</p>
         * @return returns true if the button has been clicked.
         */
        boolean checkMouse(){
            if(p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h/2 && p.mouseY > y - h/2){
                isHovered = true;
            } else{
                isHovered = false;
            }
            boolean pressed = p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h/2 && p.mouseY > y - h/2 && p.mousePressed;
            if(pressed)
                p.mousePressed = false;
            return pressed;
        }
    }

    /**
     * <p>Resume the game, without affecting progress.</p>
     */
    public void resume(){
        //state = GUIState.Game;
        currentScreen = gameScreen;
    }

    /**
     * <p>End the game, and send the player to the ending screen.</p>
     * @param won if the game has been won, or lost
     * @param score the base score the player achieved
     * @param remainingOxygen the player's remaining oxygen
     * @param totalTime the player's total time in the level
     */
    public void gameEnd(boolean won, int score, int remainingOxygen, int totalTime){
        this.won = won;
        this.score = score;
        this.remainingOxygen = (int)(((float)remainingOxygen / OXYGEN_CONVERSION_RATIO));
        this.totalTime = totalTime;
        //state = GUIState.End;
        currentScreen = endScreen;
    }

}
