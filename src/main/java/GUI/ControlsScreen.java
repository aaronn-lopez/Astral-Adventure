package GUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class ControlsScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.controlsScreen();
        guiManager.currentScreen = guiManager.controlsScreen;

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

        if(guiManager.backButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }
        guiManager.backButton.draw();
    }
}
