import static java.lang.Math.sin;

/**
 * <p>The 'rocket ship' tile. Colliding with this object wins the game, if you have collected all of the batteries.</p>
 */
public class EndTile extends Mapobject{

    EndTile(Transform transform){
        super(transform, "src/main/Sprites/Rocket.png");

    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }

    /**
     * <p>Check if the player has collected enough batteries to end the game.</p>
     */
    public void gameEndCheck(){
        // check if the player's collected batteries is equal to the total amount of batteries
        if(GameManager.gameManager.totalBatteries == GameManager.gameManager.completionCount)
        {
            GameManager.gameManager.score = (GameManager.gameManager.baseScore + (int)(((float)GameManager.gameManager.oxygen / GameManager.gameManager.maxOxygen) * 100)) - GameManager.gameManager.elapsedTime;
            GameManager.gameManager.scoreboard.updateScoreboard(GameManager.gameManager.score, GameManager.gameManager.level);
            GUIManager.guiManager.gameEnd(true, GameManager.gameManager.score, GameManager.gameManager.oxygen, GameManager.gameManager.elapsedTime);
        }
    }

    @Override
    public void onHit() {
        gameEndCheck();
    }
}
