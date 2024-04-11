package GUI;

import processing.core.PApplet;

public class ScoreboardScreen extends GUIScreen{
    @Override
    public void display() {
        GUIManager.guiManager.scoreboardScreen();
    }
}
