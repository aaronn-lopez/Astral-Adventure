package GUI;

import processing.core.PApplet;

public class EndScreen extends GUIScreen{
    @Override
    public void display() {
        GUIManager.guiManager.endingScreen();
    }
}
