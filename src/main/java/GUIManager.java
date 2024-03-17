import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PFont;

import static processing.core.PApplet.println;
import static processing.core.PConstants.*;

public class GUIManager {
    public GUIState state = GUIState.Start;

    public static GUIManager  guiManager;
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


    GUIManager(PApplet p){
        guiManager = this;
        this.p = p;

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

    class Button {
        float x;
        float y;
        float w;
        float h;
        int color;
        String text;

        boolean isHovered;
        Button(float x, float y, float w, float h, String text, int color){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;

            this.text = text;
            this.color = color;
        }

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

    void gameGUI(){
        p.fill(255);
        p.textSize(30);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text("Time: " + GameManager.gameManager.elapsedTime, 10, 25);
        p.text("Score: " + GameManager.gameManager.baseScore, 1050, 25);
        p.text("Oxygen: " + (int)(((float)GameManager.gameManager.oxygen / GameManager.gameManager.maxOxygen) * 100) + "%", 1050, 50);
        p.text("Batteries: " + GameManager.gameManager.completionCount + "/" + GameManager.gameManager.totalBatteries, 1050, 75);
    }

    void pause(){
        state = GUIState.Pause;

        p.fill(0);
        p.noStroke();
        p.rectMode(PConstants.CORNERS);
        p.rect(0, 0, 1280, 720);

        p.fill(255);
        p.textSize(100);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text("Paused", 1280/2, 720/3);
        p.textSize(35);
        p.text("(Press ESC to unpause)", 1280/2, 720/2 - 30);

        if(mainMenuButton.checkMouse()){
            state = GUIState.Start;
        }
        else if(restartLvButton.checkMouse()){
            GameManager.gameManager.startLevel(GameManager.gameManager.level);
            Processing.player = (Player)GameManager.gameManager.player;
            state = GUIState.Game;
        }
        mainMenuButton.draw();
        restartLvButton.draw();

    }

    void resume(){
        state = GUIState.Game;
    }


    void startScreen(){
        state = GUIState.Start;

        p.imageMode(PConstants.CORNERS);
        p.rectMode(PConstants.CORNERS);
        PImage image = p.loadImage("src/main/Sprites/StartScreenBackground.png");
        p.image(image, 0, 0, 1280, 720);

        p.noStroke();

        p.fill(255);
        p.textSize(132);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text("Astral Adventures", 1280/2, 720/4);

        p.imageMode(PConstants.CORNER);

        if(startButton.checkMouse()){
            state = GUIState.DifficultySelect;
        }
        else if(instructionsButton.checkMouse()) {
            state = GUIState.Help;
        }
        else if(leaderboardButton.checkMouse()){
            state = GUIState.Scoreboard;
        }
        else if(controlsButton.checkMouse()){
            state = GUIState.Controls;
        }

        startButton.draw();
        instructionsButton.draw();
        controlsButton.draw();
        leaderboardButton.draw();
    }

    void scoreboardScreen(){
        state = GUIState.Scoreboard;
        int xspacing = 600;
        int yspacing = 175;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

        p.fill(255);
        p.textSize(40);
        p.stroke(255);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                p.textAlign(PConstants.CENTER, PConstants.TOP);
                p.text("Level " + (2*i+j+1) + " High Scores", 350 + j * xspacing, 50 + i * yspacing);
                p.line(150 + j * xspacing,80 + i * yspacing,550 + j * xspacing,80 + i * yspacing);
                p.textAlign(PConstants.LEFT, PConstants.TOP);
                p.text("1st\n2nd\n3rd", 150 + j * xspacing, 90 + i * yspacing);
                p.textAlign(PConstants.RIGHT, PConstants.TOP);
                p.text(GameManager.gameManager.scoreboard.getScores(2*i+j+1), 550 + j * xspacing, 90 + i * yspacing);
            }
        }

        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.text("Level 5 High Scores", 600 ,425);
        p.line(390,454,805 ,454);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text("1st\n2nd\n3rd", 390, 467);
        p.textAlign(PConstants.RIGHT, PConstants.TOP);
        p.text(GameManager.gameManager.scoreboard.getScores(5), 805, 467);


        if(backButton.checkMouse()){
            state = GUIState.Start;
        }
        backButton.draw();

    }

    void helpScreen(){
        state = GUIState.Help;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

        p.fill(255);
        p.textSize(30);

        PFont font1;
        PFont font2;
        font1 = p.createFont("src/main/Sprites/pixelFont.ttf", 30);
        font2 = p.createFont("src/main/Sprites/pixelFont2.ttf", 30);
        p.textFont(font2);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text(
                    "Your ship ran out of power, stranding you on an unknown planet...\n\n" +
                        "Your goal is to collect all of the batteries so\nthat you can power your rocket and leave!\n\n" +
                        "Oxygen is limited, so make sure to pick up some oxygen\ntanks on the way. But be careful, they will disappear!\n" +
                        "If you run out of oxygen, you will lose\n\n" +
                        "Avoid the sharp spikes and alien creatures; \nhitting them causes you to lose oxygen!\n\n" +
                        "Blackholes can teleport you to other blackholes! \nExplore to figure out which one leads where!\n",
                100, 150);
        p.textFont(font1);

        if(backButton.checkMouse()){
            state = GUIState.Start;
        }
        backButton.draw();
    }
    void controlsScreen(){
        state = GUIState.Controls;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

        p.fill(255);
        p.textSize(30);

        PFont font1;
        PFont font2;
        font1 = p.createFont("src/main/Sprites/pixelFont.ttf", 50);
        font2 = p.createFont("src/main/Sprites/pixelFont2.ttf", 50);
        p.textFont(font2);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text("Move Up:\n\n" + "Move Down:\n\n" + "Move Left:\n\n" + "Move Right:\n\n\n" + "Pause/Unpause Game:", 150, 75);
        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.text("""
                W

                S

                A

                D


                [ESC]""", 950, 75);
        p.textFont(font1);

        if(backButton.checkMouse()){
            state = GUIState.Start;
        }
        backButton.draw();
    }

    void difficultyScreen(){
        state = GUIState.DifficultySelect;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

        p.textSize(64);
        p.text("Select Difficulty", 1280/2, 720/4);

        if(backButton.checkMouse()){
            state = GUIState.Start;
        }
        for(int i = 0; i < levels.length; i++){
            if(levels[i].checkMouse()){
                GameManager.gameManager.startLevel(i + 1);
                Processing.player = (Player)GameManager.gameManager.player;
                state = GUIState.Game;
            }
        }

        backButton.draw();
        for(int i = 0; i < levels.length; i++){
            levels[i].draw();
        }
    }

    boolean won;
    int score;
    public int remainingOxygen;
    public int totalTime;

    void gameEnd(boolean won, int score, int remainingOxygen, int totalTime){
        this.won = won;
        this.score = score;
        this.remainingOxygen = (int)(((float)remainingOxygen / GameManager.gameManager.maxOxygen) * 100);
        this.totalTime = totalTime;
        state = GUIState.End;
    }

    void endingScreen(){
        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.imageMode(CORNERS);
        p.image(image, 0, 0, 1280, 720);

        p.textAlign(CENTER,CENTER);
        p.textSize(95);

        if(won){
            p.fill(200, 200, 0);
            p.text("You won!", 1280/2, 720/9 + 15);
        }
        else{
            p.fill(129, 59, 9);
            p.text("You lost!", 1280/2, 720/9 + 15);
        }

        p.textAlign(RIGHT,CENTER);
        p.stroke(255);
        p.fill(255,255,255);
        p.textSize(45);

        p.text("Base Score: " + GameManager.gameManager.baseScore, 1280/2 + 175, 720/6 + 125);
        p.text("+ oxygen: " + remainingOxygen, 1280/2 + 175, 720/4 + 100);
        p.text("- time: " + totalTime, 1280/2 + 175, 720/3 + 70);
        p.line(465,720/3 + 90,825 ,720/3 + 90);
        p.text("Final Score: " + score, 1280/2 + 175, 720/3 + 115);

        if(playAgainButton.checkMouse()){
            GameManager.gameManager.startLevel(GameManager.gameManager.level);
            Processing.player = (Player)GameManager.gameManager.player;
            state = GUIState.Game;
        }
        if(exitToMainMenuButton.checkMouse()){
            state = GUIState.Start;
        }

        playAgainButton.draw();
        exitToMainMenuButton.draw();
    }
}
