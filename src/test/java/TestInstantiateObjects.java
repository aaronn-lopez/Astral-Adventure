import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestInstantiateObjects {
    private GameManager gameManager;

    @Before
    public void setUp() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");
        gameManager = GameManager.gameManager;
    }
    @Test
    public void testInstantiatePlayer() {
        // Check if player is instantiated
        Gameobject player = gameManager.player;
        assertNotNull("Player should be instantiated", player);
    }
    @Test
    public void testInstantiateWalkingAlien() {
        // Check the number of enemies present on the map
        int expectedNumWalkingAliens = 1; // Assuming only one walking alien is present on the map
        int actualNumWalkingAliens = 0;
        for(int i = 0; i < gameManager.enemies.size(); i++){
            if(gameManager.enemies.get(i) instanceof Spike){
                actualNumWalkingAliens++;
            }
        }
        int actualNumEnemies = gameManager.enemies.size();

        assertEquals("Number of walking aliens should match", expectedNumWalkingAliens, actualNumWalkingAliens);
    }

    @Test
    public void testNullInstantiateWalkingAlien() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroWalkingAliens.txt");

        // Check the number of enemies present on the map
        int expectedNumEnemies = 0;
        int actualNumEnemies = gameManager.enemies.size();

        assertEquals("Number of walking aliens should match", expectedNumEnemies, actualNumEnemies);
    }

    @Test
    public void testInstantiateHidingAlien() {
        // Check if hiding alien is instantiated
        int expectedNumHidingAliens = 1;
        int actualNumHidingAliens = 0;
        for(int i = 0; i < gameManager.enemies.size(); i++){
            if(gameManager.enemies.get(i) instanceof Spike){
                actualNumHidingAliens++;
            }
        }
        assertEquals("Number of hiding aliens should match", expectedNumHidingAliens, actualNumHidingAliens);
    }
}
