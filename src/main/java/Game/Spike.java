package Game;

/**
 * <p>Immobile enemy that lowers the player's oxygen on collision.</p>
 */
public class Spike extends Enemy {

    private static final int OXYGEN_LOST_SPIKE = 480;
    Spike(Transform transform){
        super(transform, "src/main/Sprites/Spike.png");
    }

   //If you hit a spike your oxygen decreases by 5% or 5 seconds
    @Override
    public void decreaseOxygen() {
        GameManager.gameManager.currentOxygen -= OXYGEN_LOST_SPIKE;
    }
}
