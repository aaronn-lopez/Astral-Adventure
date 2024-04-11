package GUI;

import processing.core.PApplet;

public class HelpScreen extends GUIScreen{
    @Override
    public void display() {
        GUIManager.guiManager.helpScreen();
    }
}
