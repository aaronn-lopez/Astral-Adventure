package GUI;

import Game.Player;
import Game.Processing;
import processing.core.PApplet;
import processing.core.PConstants;

public class PauseScreen extends GUIScreen{

    @Override
    public void display() {
        //GUIManager.guiManager.pause();
        guiManager.currentScreen = guiManager.pauseScreen;

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

        if(guiManager.mainMenuButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }
        else if(guiManager.restartLvButton.checkMouse()){
            guiManager.gameManager.startLevel(guiManager.gameManager.level);
            Processing.player = (Player)guiManager.gameManager.player;
            //state = GUIState.Game;
            guiManager.currentScreen = guiManager.gameScreen;
        }
        guiManager.mainMenuButton.draw();
        guiManager.restartLvButton.draw();

    }
}
