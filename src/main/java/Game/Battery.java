package Game;

import Game.GameManager;

/**
<p>Collectable Battery used to progress in the game. Collecting the required amount allows you to end the game by touching the end tile.</p>
 */
public class Battery extends Collectable{
    Battery(Transform transform){
        super(transform, "src/main/Sprites/Battery.png");
    }

    //Increase score by 100 points and add to total collected batteries
    @Override
    public void collect() {
        GameManager.gameManager.baseScore += 100;
        GameManager.gameManager.completionCount++;
    }
}
