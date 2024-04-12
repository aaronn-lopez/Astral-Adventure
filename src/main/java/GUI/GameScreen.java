package GUI;
import Game.*;
import processing.core.PConstants;

public class GameScreen extends GUIScreen{
    @Override
    public void display() {
        //GUIManager.guiManager.gameGUI();
        p.fill(255);
        p.textSize(30);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text("Time: " + GameManager.gameManager.elapsedTime, 10, 25);
        p.text("Score: " + GameManager.gameManager.baseScore, 1050, 25);
        p.text("Oxygen: " + (int)(((float)GameManager.gameManager.currentOxygen / GameManager.gameManager.maxOxygen) * 100) + "%", 1050, 50);
        p.text("Batteries: " + GameManager.gameManager.collectedBatteries + "/" + GameManager.gameManager.totalBatteries, 1050, 75);
    }
}
