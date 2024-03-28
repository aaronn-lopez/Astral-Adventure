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
    public void testStartLevel() {
        gameManager.startLevel(1);
        assertEquals("Oxygen should be initialized based on level", 4000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);
    }
}
