package GUI;

import processing.core.PApplet;

public class PauseScreen extends GUIScreen{

    @Override
    public void display() {
        GUIManager.guiManager.pause();
    }
}
