package GUI;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class HelpScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.helpScreen();
        guiManager.currentScreen = guiManager.helpScreen;

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
                "Your ship ran out of power, stranding you on an unknown planet...\n\n" +
                        "Your goal is to collect all of the batteries so\nthat you can power your rocket and leave!\n\n" +
                        "Oxygen is limited, so make sure to pick up some oxygen\ntanks on the way. But be careful, they will disappear!\n" +
                        "If you run out of oxygen, you will lose\n\n" +
                        "Avoid the sharp spikes hitting them causes you to lose oxygen!\n\n" +
                        "Hitting the walking aliens causes you to lose the game immediately!\n\n" +
                        "Blackholes can teleport you to other blackholes! \nExplore to figure out which one leads where!\n",
                100, 150);
        p.textFont(font1);

        if(guiManager.backButton.checkMouse()){
            //state = GUIState.Start;
            guiManager.currentScreen = guiManager.startScreen;
        }
        guiManager.backButton.draw();
    }
}
