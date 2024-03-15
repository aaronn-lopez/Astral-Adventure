import processing.core.PApplet;
import processing.core.PConstants;

public class GUIManager {
    public GUIState state = GUIState.Game;
    private boolean pauseBuffer = true;

    GUIManager  guiManager;
    PApplet p;


    GUIManager(PApplet p){
        guiManager = this;
        this.p = p;
    }

    void pause(){
        state = GUIState.Pause;

        if(pauseBuffer) {
            p.fill(0, 180);
            p.noStroke();
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
    }

    void scoreboardScreen(){
        state = GUIState.Scoreboard;
    }

    void helpScreen(){
            state = GUIState.Help;
    }
}
