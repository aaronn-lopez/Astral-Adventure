package GUI;

import processing.core.PApplet;

public abstract class GUIScreen {
    public static PApplet p;
    public static GUIManager guiManager;

    public static void init(PApplet app, GUIManager gui){
        p = app;
        guiManager = gui;
    }
    public abstract void display();
}
