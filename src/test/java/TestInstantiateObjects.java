import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestInstantiateObjects {
    private GameManager gameManager;

    @Before
    public void setUp() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");
        gameManager = GameManager.gameManager;
    }

    @Test
    public void testInstantiateWalkingAlien() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMap.txt");

        // Check the number of enemies present on the map
        int expectedNumEnemies = 1; // Assuming only one walking alien is present on the map
        int actualNumEnemies = gameManager.enemies.size();

        assertEquals("Number of walking aliens should match", expectedNumEnemies, actualNumEnemies);
    }

    @Test
    public void testNullInstantiateWalkingAlien() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroWalkingAliens.txt");

        // Check the number of enemies present on the map
        int expectedNumEnemies = 0; // Assuming zero walking aliens are present on the map
        int actualNumEnemies = gameManager.enemies.size();

        assertEquals("Number of walking aliens should match", expectedNumEnemies, actualNumEnemies);
    }
}
