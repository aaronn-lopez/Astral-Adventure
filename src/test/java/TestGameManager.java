import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
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
        // Start a level that doesn't exist, e.g., level 0
        gameManager.startLevel(0);

        assertEquals("GameManager should not modify oxygen for an invalid level", 0, gameManager.oxygen);
        assertEquals("GameManager should not modify oxygen rate for an invalid level", 0, gameManager.oxygenRate);
        assertEquals("GameManager should not modify oxygen tank disappear time for an invalid level", 0, gameManager.oxygenTankDisappearTime);
    }
}
