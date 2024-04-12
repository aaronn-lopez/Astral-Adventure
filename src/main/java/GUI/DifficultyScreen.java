package GUI;

import Game.Player;
import Game.Processing;
import Levels.LevelManager;
import processing.core.PApplet;
import processing.core.PImage;

public class DifficultyScreen extends GUIScreen{

    LevelManager lvManager = new LevelManager();
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
                if(i == 0){
                    lvManager.selectedLv = lvManager.easyLv;
                }
                else if(i == 1) {
                    lvManager.selectedLv = lvManager.normalLv;
                }
                else if(i == 2) {
                    lvManager.selectedLv = lvManager.intermediateLv;
                }
                else if(i == 3) {
                    lvManager.selectedLv = lvManager.hardLv;
                }
                else if(i == 4) {
                    lvManager.selectedLv = lvManager.veryHardLv;
                }

                lvManager.selectedLv.setSpecs();
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
