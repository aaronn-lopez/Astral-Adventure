import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains unit tests for collision detection and handling in the game.
 */
public class CollisionTests {
    private GameManager gameManager;

    /**
     * Sets up the initial test sandbox game before each test method.
     */
    @Before
    public void setUp() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");
        gameManager = GameManager.gameManager;
    }
}
