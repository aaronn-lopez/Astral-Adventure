package GUI;

import processing.core.PApplet;

public abstract class GUIScreen {
    public static PApplet p;
    public GUIManager guiManager;

    public static void init(PApplet app){
        p = app;
    }
    public abstract void display();
}
