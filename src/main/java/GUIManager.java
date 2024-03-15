import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PFont;

public class GUIManager {
    public GUIState state = GUIState.Start;

    GUIManager  guiManager;
    PApplet p;

    Button startButton;
    Button instructionsButton;
    Button backButton;
    Button leaderboardButton;
    Button mainMenuButton;
    Button[] levels;


    GUIManager(PApplet p){
        guiManager = this;
        this.p = p;

        startButton = new Button(1280 / 2 - 200, 720 / 2 + 200, 300, 100, "Start Game", p.color(255, 100));
        instructionsButton = new Button(1280 / 2 + 200, 720 / 2 + 200, 300, 100, "Instructions", p.color(255, 100));
        backButton = new Button(60, 60, 100, 80, "Back", p.color(255, 100));
        leaderboardButton = new Button(1100, 60, 300, 80, "Leaderboard", p.color(255, 100));
        mainMenuButton = new Button(1280 / 2, 720 / 2 + 100, 200, 100, "Main Menu", p.color(255, 100));

        levels = new Button[5];
        levels[0] = new Button(1280 / 2 - 150, 720 / 2, 50, 50, "1", p.color(255, 100));
        levels[1] = new Button(1280 / 2 - 75, 720 / 2, 50, 50, "2", p.color(255, 100));
        levels[2] = new Button(1280 / 2, 720 / 2, 50, 50, "3", p.color(255, 100));
        levels[3] = new Button(1280 / 2 + 75, 720 / 2, 50, 50, "4", p.color(255, 100));
        levels[4] = new Button(1280 / 2 + 150, 720 / 2, 50, 50, "5", p.color(255, 100));
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

            return p.mouseX < x + w/2 && p.mouseX > x - w/2 && p.mouseY < y + h/2 && p.mouseY > y - h/2 && p.mousePressed;
        }
    }

    void gameGUI(){
        p.fill(255);
        p.textSize(30);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text("Seconds Elapsed:\n" + GameManager.gameManager.elapsedTime, 10, 25);
        p.text("Score: " + GameManager.gameManager.score, 1050, 25);
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

        if(mainMenuButton.checkMouse()){
            state = GUIState.Start;
        }
        mainMenuButton.draw();

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

        startButton.draw();
        instructionsButton.draw();
        leaderboardButton.draw();
    }

    void scoreboardScreen(){
        state = GUIState.Scoreboard;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

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
                    "Your ship ran out of power, stranding you on an unknown planet\n\n" +
                        "Your goal is to collect all of the batteries, \nin order to power your rocket and leave!\n\n" +
                        "Oxygen is limited, \nso make sure to pick up some oxygen tanks on the way;\n" +
                        "If you run out of oxygen, you lose\n\n" +
                        "Avoid the spikes and alien creatures; \nhitting them causes you to lose oxygen!\n\n" +
                        "Blackholes can teleport you to other blackholes! \nExplore to figure out which one leads where!\n",
                100, 150);
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
}
