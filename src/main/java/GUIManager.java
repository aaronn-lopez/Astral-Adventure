import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class GUIManager {
    public GUIState state = GUIState.Start;
    private boolean pauseBuffer = true;

    GUIManager  guiManager;
    PApplet p;

    Button startButton;
    Button instructionsButton;


    GUIManager(PApplet p){
        guiManager = this;
        this.p = p;

        startButton = new Button(1280 / 2 - 200, 720 / 2 + 200, 300, 150, "Start Game", p.color(255, 100));
        instructionsButton = new Button(1280 / 2 + 200, 720 / 2 + 200, 300, 150, "Instructions", p.color(255, 100));
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

    void pause(){
        state = GUIState.Pause;

        if(pauseBuffer) {
            p.fill(0, 180);
            p.noStroke();
            p.rectMode(PConstants.CORNERS);
            p.rect(0, 0, 1280, 720);

            p.fill(255);
            p.textSize(100);
            p.textAlign(PConstants.CENTER, PConstants.CENTER);
            p.text("Paused", 1280/2, 720/3);
            pauseBuffer = false;
        }
    }

    void resume(){
        state = GUIState.Game;
        pauseBuffer = true;
    }


    void startScreen(){
        state = GUIState.Start;

        PImage image = p.loadImage("src/main/Sprites/StartScreenBackground.png");
        p.image(image, 0, 0, 1280, 720);

        p.noStroke();

        p.fill(255);
        p.textSize(100);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text("Astral Adventures", 1280/2, 720/5);

        if(startButton.checkMouse()){
            state = GUIState.Game;
        }
        else if(instructionsButton.checkMouse()) {
            state = GUIState.Help;
        }

        startButton.draw();
        instructionsButton.draw();
    }

    void scoreboardScreen(){
        state = GUIState.Scoreboard;
    }

    void helpScreen(){
            state = GUIState.Help;
    }
}
