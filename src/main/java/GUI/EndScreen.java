package GUI;

import Game.Player;
import Game.Processing;
import Levels.LevelManager;
import processing.core.PApplet;
import processing.core.PImage;

import static processing.core.PConstants.*;
import static processing.core.PConstants.CENTER;

public class EndScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.endingScreen();
        PImage image = p.loadImage("src/main/Sprites/Space Background.png");
        p.imageMode(CORNERS);
        p.image(image, 0, 0, 1280, 720);

        p.textAlign(CENTER,CENTER);
        p.textSize(95);

        if(guiManager.won){
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

        p.text("Base Score: " + guiManager.gameManager.baseScore, 1280/2 + 175, 720/6 + 125);
        p.text("+ oxygen: " + guiManager.remainingOxygen, 1280/2 + 175, 720/4 + 100);
        p.text("- time: " + guiManager.totalTime, 1280/2 + 175, 720/3 + 70);
        p.line(465,720/3 + 90,825 ,720/3 + 90);
        p.text("Final Score: " + guiManager.score, 1280/2 + 175, 720/3 + 115);

        if(guiManager.playAgainButton.checkMouse()){
            LevelManager.lvManager.selectedLv.setSpecs();
            Processing.player = (Player)guiManager.gameManager.player;
            //state = GUIState.Game;
            guiManager.currentScreen = guiManager.gameScreen;
        }
        if(guiManager.exitToMainMenuButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }

        guiManager.playAgainButton.draw();
        guiManager.exitToMainMenuButton.draw();
    }
}
