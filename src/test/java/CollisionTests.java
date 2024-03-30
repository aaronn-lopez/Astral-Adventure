import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CollisionTests {

    private GameManager gameManager;

    @Before
    public void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void playerWalkingAlienCollision() {
        // Create a mock Player object
        Player playerMock = mock(Player.class);
        // Set the player's position
        playerMock.setPosition(0, 0);
        // Set the player in the game manager
        gameManager.player = playerMock;

        // Create a mock WalkingAlien object
        WalkingAlien alienMock = mock(WalkingAlien.class);
        // Set the alien's position
        alienMock.setPosition(0, 0);
        // Set the alien in the game manager
        gameManager.enemies.add(alienMock);

        // Perform collision check
        playerMock.checkCollisions();

        // Verify that decreaseOxygen method is called on the alienMock
        verify(alienMock).decreaseOxygen();
    }
}
