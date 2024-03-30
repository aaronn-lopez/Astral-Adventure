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

    @Test
    public void testNoBatteries() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumBatteries = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", 0, actualNumBatteries);
    }

    @Test
    public void testInstantiateBatteries() {
        // Check if batteries are instantiated
        int expectedNumBatteries = 1;
        int actualNumBatteries = countObject(Battery.class);
        assertEquals("Number of batteries should match", expectedNumBatteries, actualNumBatteries);
    }

    @Test
    public void testNoBlackholes() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        // Check if no blackholes are instantiated
        int actualNumBlackholes = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", 0, actualNumBlackholes);
    }
    @Test
    public void testInstantiateBlackholes() {
        // Check if blackholes are instantiated
        int expectedNumBlackholes = 1;
        int actualNumBlackholes = countObject(Blackhole.class);
        assertEquals("Number of blackholes should match", expectedNumBlackholes, actualNumBlackholes);
    }
    @Test
    public void testNoOxygenTanks() {
        Map map = new Map();
        map.newMap("src/test/resources/TestLevels/dummyMapWithZeroObjects.txt");

        int actualNumOxygenTanks = countObject(OxygenTank.class);
        assertEquals("Number of oxygen tanks should match", 0, actualNumOxygenTanks);
    }
    @Test
    public void testInstantiateOxygenTanks() {
        int expectedNumOxygenTanks = 1;
        int actualNumOxygenTanks = countObject(OxygenTank.class);
        assertEquals("Number of blackholes should match", expectedNumOxygenTanks, actualNumOxygenTanks);
    }
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
