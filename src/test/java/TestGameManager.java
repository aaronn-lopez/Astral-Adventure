import Game.GameManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import Game.*;

/**
 * Test class for GameManager.GameManager functionality.
 */
public class TestGameManager {

    private GameManager gameManager;

    /**
     * Set up method to initialize GameManager.GameManager and mock dependencies.
     */
    @Before
    public void setUp() {
        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager.GameManager
        gameManager = new GameManager();
    }

    /**
     * testLevel helper function to test a valid level initialization
     * @param levelInt a valid level number (1-5)
     */
    void testLevel(int levelInt) {

        switch (levelInt) {
            case 1:
                gameManager.startLevel(1);
                assertEquals("Oxygen should be initialized to 4000 for level 1", 4000, gameManager.currentOxygen);
                assertEquals("Oxygen rate should be initialized to 1 on level 1", 1, gameManager.oxygenDecreaseRate);
                assertEquals("Oxygen tank disappear time should be initialized to 45 for level 1", 45, gameManager.oxygenTankDisappearTime);
                break;
            case 2:
                gameManager.startLevel(2);
                assertEquals("Oxygen should be initialized to 3500 for level 2", 3500, gameManager.currentOxygen);
                assertEquals("Oxygen rate should be initialized to 1 on level 2", 1, gameManager.oxygenDecreaseRate);
                assertEquals("Oxygen tank disappear time should be initialized to 30 for level 2", 30, gameManager.oxygenTankDisappearTime);
                break;
            case 3:
                gameManager.startLevel(3);
                assertEquals("Oxygen should be initialized to 3000 for level 3", 3000, gameManager.currentOxygen);
                assertEquals("Oxygen rate should be initialized to 1 on level 3", 1, gameManager.oxygenDecreaseRate);
                assertEquals("Oxygen tank disappear time should be initialized to 20 for level 3", 20, gameManager.oxygenTankDisappearTime);
                break;
            case 4:
                gameManager.startLevel(4);
                assertEquals("Oxygen should be initialized to 2500 for level 4", 2500, gameManager.currentOxygen);
                assertEquals("Oxygen rate should be initialized to 2 on level 4", 2, gameManager.oxygenDecreaseRate);
                assertEquals("Oxygen tank disappear time should be initialized to 20 for level 4", 20, gameManager.oxygenTankDisappearTime);
                break;
            case 5:
                gameManager.startLevel(5);
                assertEquals("Oxygen should be initialized to 2000 for level 5", 2000, gameManager.currentOxygen);
                assertEquals("Oxygen rate should be initialized to 2 on level 5", 2, gameManager.oxygenDecreaseRate);
                assertEquals("Oxygen tank disappear time should be initialized to 15 for level 5", 15, gameManager.oxygenTankDisappearTime);
                break;
            default:
                // easily assert an error because the levelInt value is invalid
                assertEquals("error in test code: invalid levelInt entry", 1,0);
                break;
        }
    }
    @Test
    public void testValidLevels() {
        testLevel(1);
        testLevel(2);
        testLevel(3);
        testLevel(4);
        testLevel(5);
    }

    /**
     * Test case for starting an invalid level.
     */
    @Test
    public void testInvalidLevel() {
        // Save initial GameManager.GameManager state
        int initialOxygen = gameManager.currentOxygen;
        int initialOxygenRate = gameManager.oxygenDecreaseRate;
        int initialOxygenTankDisappearTime = gameManager.oxygenTankDisappearTime;

        // Start an invalid level (level 0)
        gameManager.startLevel(0);

        // Assert that GameManager.GameManager state remains unchanged
        assertEquals("Oxygen should remain unchanged for an invalid level", initialOxygen, gameManager.currentOxygen);
        assertEquals("Oxygen rate should remain unchanged for an invalid level", initialOxygenRate, gameManager.oxygenDecreaseRate);
        assertEquals("Oxygen tank disappear time should remain unchanged for an invalid level", initialOxygenTankDisappearTime, gameManager.oxygenTankDisappearTime);
    }

    /**
     * Test case for resetting GameManager.GameManager.
     */
    @Test
    public void testReset() {
        // Set initial values then test that it reset to 0
        gameManager.finalScore = 100;
        gameManager.collectedBatteries = 5;
        gameManager.totalBatteries = 5;
        gameManager.elapsedTime = 30;

        GameManager.reset();

        assertEquals("Score should be reset to 0", 0, gameManager.finalScore);
        assertEquals("Completion count should be reset to 0", 0, gameManager.collectedBatteries);
        assertEquals("Total batteries should be reset to 0", 0, gameManager.totalBatteries);
        assertEquals("Elapsed time should be reset to 0", 0, gameManager.elapsedTime);
    }

    /**
     * Test case for retrieving an enemy.
     */
    @Test
    public void getEnemyTest(){
        gameManager.startLevel(1);

        Enemy enemy = (Enemy)GameManager.getCell(6, 5).enemy;
        Enemy enemyTest = GameManager.getEnemy(6, 5);

        assertEquals(enemy, enemyTest);

    }
}
