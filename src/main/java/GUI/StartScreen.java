package GUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class StartScreen extends GUIScreen{

    @Override
    public void display() {
        //GUIManager.guiManager.startScreen();
        guiManager.currentScreen = guiManager.startScreen;

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

        if(guiManager.startButton.checkMouse()){
            //state = GUIState.DifficultySelect;
            guiManager.currentScreen = guiManager.difficultyScreen;
        }
        else if(guiManager.instructionsButton.checkMouse()) {
            //state = GUIState.Help;
            guiManager.currentScreen = guiManager.helpScreen;
        }
        else if(guiManager.leaderboardButton.checkMouse()){
            //state = GUIState.Scoreboard;
            guiManager.currentScreen = guiManager.scoreboardScreen;
        }
        else if(guiManager.controlsButton.checkMouse()){
            //state = GUIState.Controls;
            guiManager.currentScreen = guiManager.controlsScreen;
        }

        guiManager.startButton.draw();
        guiManager.instructionsButton.draw();
        guiManager.controlsButton.draw();
        guiManager.leaderboardButton.draw();
    }
}
