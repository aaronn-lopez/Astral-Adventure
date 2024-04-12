import Game.GameManager;
import org.junit.Before;
import org.junit.Test;
import Levels.LevelManager;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import Game.*;

/**
 * Test class for instantiating game objects and correctly counting them.
 */
public class TestInstantiateObjects {
    private GameManager gameManager;

    /**
     * Set up method to initialize GameManager.GameManager and load map for testing.
     */
    @Before
    public void setUp() {

        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager.GameManager
        gameManager = new GameManager();

        LevelManager lvManager = new LevelManager();
        lvManager.testLv.setSpecs();
    }

    /**
     * Test case to check instantiation of player.
     */
    @Test
    public void testInstantiatePlayer() {
        // Check if player is instantiated
        Gameobject player = gameManager.player;
        assertNotNull("Player should be instantiated", player);
    }

    /**
     * Test case to check if there are no walking aliens.
     */
    @Test
    public void testNullInstantiateWalkingAlien() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumWalkingAliens = 0;
        for(int i = 0; i < gameManager.enemies.size(); i++){
            if(gameManager.enemies.get(i) instanceof WalkingAlien){
                actualNumWalkingAliens++;
            }
        }

        assertEquals("Number of walking aliens should match", 0, actualNumWalkingAliens);
    }

    /**
     * Test case to check instantiation of walking aliens.
     */
    @Test
    public void testInstantiateWalkingAlien() {
        // Check the number of enemies present on the map
        int expectedNumWalkingAliens = 1;
        int actualNumWalkingAliens = 0;
        for(int i = 0; i < gameManager.enemies.size(); i++){
            if(gameManager.enemies.get(i) instanceof Spike){
                actualNumWalkingAliens++;
            }
        }
        int actualNumEnemies = gameManager.enemies.size();

        assertEquals("Number of walking aliens should match", expectedNumWalkingAliens, actualNumWalkingAliens);
    }

    /**
     * Test case to check if there are no hiding aliens.
     */
    @Test
    public void testNoHidingAlien() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumHidingAliens = 0;
        for(int i = 0; i < gameManager.enemies.size(); i++){
            if(gameManager.enemies.get(i) instanceof Spike){
                actualNumHidingAliens++;
            }
        }

        assertEquals("Number of walking aliens should match", 0, actualNumHidingAliens);
    }

    /**
     * Test case to check instantiation of hiding aliens.
     */
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

    /**
     * Test case to check if there are no batteries.
     */
    @Test
    public void testNoBatteries() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumBatteries = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", 0, actualNumBatteries);
    }

    /**
     * Test case to check instantiation of batteries.
     */
    @Test
    public void testInstantiateBatteries() {
        // Check if batteries are instantiated
        int expectedNumBatteries = 1;
        int actualNumBatteries = countObject(Battery.class);
        assertEquals("Number of batteries should match", expectedNumBatteries, actualNumBatteries);
    }

    /**
     * Test case to check if there are no blackholes.
     */
    @Test
    public void testNoBlackholes() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        // Check if no blackholes are instantiated
        int actualNumBlackholes = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", 0, actualNumBlackholes);
    }

    /**
     * Test case to check instantiation of blackholes.
     */
    @Test
    public void testInstantiateBlackholes() {
        // Check if blackholes are instantiated
        int expectedNumBlackholes = 1;
        int actualNumBlackholes = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", expectedNumBlackholes, actualNumBlackholes);
    }

    /**
     * Test case to check if there are no oxygen tanks.
     */
    @Test
    public void testNoOxygenTanks() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumOxygenTanks = countObject(OxygenTank.class);
        assertEquals("Number of oxygen tanks should match", 0, actualNumOxygenTanks);
    }

    /**
     * Test case to check instantiation of oxygen tanks.
     */
    @Test
    public void testInstantiateOxygenTanks() {
        int expectedNumOxygenTanks = 1;
        int actualNumOxygenTanks = countObject(OxygenTank.class);
        assertEquals("Number of blackholes should match", expectedNumOxygenTanks, actualNumOxygenTanks);
    }

    /**
     * Helper method to count objects of a specific class.
     *
     * @param typeOfInteractable The class of the objects to count.
     * @return The count of objects of the specified class.
     */
    private int countObject(Class<?> typeOfInteractable) {
        int count = 0;
        for (int i = 0; i < gameManager.gridX; i++) {
            for (int j = 0; j < gameManager.gridY; j++) {
                if (typeOfInteractable.isInstance(GameManager.getCell(i, j).interactable)) {
                    count++;
                }
            }
        }
        return count;
    }
}
