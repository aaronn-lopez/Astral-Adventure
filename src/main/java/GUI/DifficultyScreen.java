package GUI;

import Game.Player;
import Game.Processing;
import processing.core.PApplet;
import processing.core.PImage;

public class DifficultyScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.difficultyScreen();
        guiManager.currentScreen = guiManager.difficultyScreen;

        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.image(image, 0, 0, 1280, 720);

        p.textSize(64);
        p.text("Select Difficulty", 1280/2, 720/4);

        if(guiManager.backButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }
        for(int i = 0; i < guiManager.levels.length; i++){
            if(guiManager.levels[i].checkMouse()){
                guiManager.gameManager.startLevel(i + 1);
                Processing.player = (Player)guiManager.gameManager.player;
                //state = GUIState.Game;
                guiManager.currentScreen = guiManager.gameScreen;
            }
        }

        guiManager.backButton.draw();
        for(int i = 0; i < guiManager.levels.length; i++){
            guiManager.levels[i].draw();
        }
    }
}
