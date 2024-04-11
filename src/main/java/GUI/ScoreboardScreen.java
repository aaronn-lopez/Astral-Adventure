package GUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class ScoreboardScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.scoreboardScreen();
        guiManager.currentScreen = guiManager.scoreboardScreen;

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
                p.text(guiManager.gameManager.scoreboard.getScores(2*i+j+1), 550 + j * xspacing, 90 + i * yspacing);
            }
        }

        p.textAlign(PConstants.CENTER, PConstants.TOP);
        p.text("Level 5 High Scores", 600 ,425);
        p.line(390,454,805 ,454);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text("1st\n2nd\n3rd", 390, 467);
        p.textAlign(PConstants.RIGHT, PConstants.TOP);
        p.text(guiManager.gameManager.scoreboard.getScores(5), 805, 467);


        if(guiManager.backButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }
        guiManager.backButton.draw();

    }
}
