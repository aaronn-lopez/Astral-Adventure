import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * This class contains unit tests for collision detection and handling in the game.
 */
public class CollisionTests {

    //gameobject = new Player(new Transform(x * 64, y * 64, 0, 1));
    //gameManager.cells[x][y].player = gameobject;
    //gameobject.setPosition(x, y);
    //gameManager.player = gameobject;
    // break;
    //case WalkingAlien:
    //gameobject = new WalkingAlien(new Transform(x * 64, y * 64, 0, 1));
    //getCell(x, y).enemy = gameobject;
    //gameobject.setPosition(x, y);
    //gameManager.enemies.add(gameobject);
    // break;

    /**
     * Sets up the initial test sandbox game before each test method.
     */
    @Before
    public void setUp() {
        // Create a mock for Gameobject
        Gameobject gameobjectMock = mock(Gameobject.class);

        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager
        GameManager gameManager = new GameManager();
    }

    @Test
    public void PlayerWalkingAlienCollision() {

    }
}
