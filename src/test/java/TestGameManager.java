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
    }

    @Test
    public void testLevel2() {
        gameManager.startLevel(2);
        assertEquals("Oxygen should be initialized to 3500 for level 2", 3500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 1 on level 2", 1, gameManager.oxygenRate);
    }

    @Test
    public void testLevel3() {
        gameManager.startLevel(3);
        assertEquals("Oxygen should be initialized to 3000 for level 3", 3000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized to 1 on level 3", 1, gameManager.oxygenRate);
    }
}
