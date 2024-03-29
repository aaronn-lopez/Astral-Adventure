import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class TestGameManager {

    private GameManager gameManager;

    @Before
    public void setUp() {
        // Create a mock for Gameobject
        Gameobject gameobjectMock = mock(Gameobject.class);

        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager
        gameManager = new GameManager();
    }

    @Test
    public void testLevel1() {
        gameManager.startLevel(1);
        assertEquals("Oxygen should be initialized to 4000 for level 1", 4000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 1 on level 1", 1, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should be initialized to 45 for level 1", 45, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testLevel2() {
        gameManager.startLevel(2);
        assertEquals("Oxygen should be initialized to 3500 for level 2", 3500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 1 on level 2", 1, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should be initialized to 30 for level 2", 30, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testLevel3() {
        gameManager.startLevel(3);
        assertEquals("Oxygen should be initialized to 3000 for level 3", 3000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 1 on level 3", 1, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should be initialized to 20 for level 3", 20, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testLevel4() {
        gameManager.startLevel(4);
        assertEquals("Oxygen should be initialized to 2500 for level 4", 2500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 2 on level 4", 2, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should be initialized to 20 for level 4", 20, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testLevel5() {
        gameManager.startLevel(5);
        assertEquals("Oxygen should be initialized to 2000 for level 5", 2000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 2 on level 5", 2, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should be initialized to 15 for level 5", 15, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testInvalidLevel() {
        // Save initial GameManager state
        int initialOxygen = gameManager.oxygen;
        int initialOxygenRate = gameManager.oxygenRate;
        int initialOxygenTankDisappearTime = gameManager.oxygenTankDisappearTime;

        // Start an invalid level (level 0)
        gameManager.startLevel(0);

        // Assert that GameManager state remains unchanged
        assertEquals("Oxygen should remain unchanged for an invalid level", initialOxygen, gameManager.oxygen);
        assertEquals("Oxygen rate should remain unchanged for an invalid level", initialOxygenRate, gameManager.oxygenRate);
        assertEquals("Oxygen tank disappear time should remain unchanged for an invalid level", initialOxygenTankDisappearTime, gameManager.oxygenTankDisappearTime);
    }

    @Test
    public void testReset() {
        // Set initial values then test that it reset to 0
        gameManager.score = 100;
        gameManager.completionCount = 5;
        gameManager.totalBatteries = 5;
        gameManager.elapsedTime = 30;

        GameManager.reset();

        assertEquals("Score should be reset to 0", 0, gameManager.score);
        assertEquals("Completion count should be reset to 0", 0, gameManager.completionCount);
        assertEquals("Total batteries should be reset to 0", 0, gameManager.totalBatteries);
        assertEquals("Elapsed time should be reset to 0", 0, gameManager.elapsedTime);
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
}
