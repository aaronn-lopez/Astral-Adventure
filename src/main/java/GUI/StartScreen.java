package GUI;

import processing.core.PApplet;

public class StartScreen extends GUIScreen{

    @Override
    public void display() {
        GUIManager.guiManager.startScreen();
    }
}
