import processing.core.PApplet;

import static java.lang.Math.sin;

public class EndTile extends Mapobject{

    EndTile(Transform transform){
        super(transform, "src/main/Sprites/Rocket.png");

    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }

    public void gameEndCheck(){
        if(GameManager.gameManager.totalBatteries == GameManager.gameManager.completionCount)
        {
            GameManager.gameManager.score = (GameManager.gameManager.baseScore + (int)(((float)GameManager.gameManager.oxygen / GameManager.gameManager.maxOxygen) * 100)) - GameManager.gameManager.elapsedTime;
            PApplet.println(GameManager.gameManager.baseScore);
            PApplet.println((int)(((float)GameManager.gameManager.oxygen / GameManager.gameManager.maxOxygen) * 100));
            PApplet.println(GameManager.gameManager.elapsedTime);
            GameManager.gameManager.scoreboard.updateScoreboard(GameManager.gameManager.score, GameManager.gameManager.level);
            GUIManager.guiManager.gameEnd(true, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
        }
    }
}
