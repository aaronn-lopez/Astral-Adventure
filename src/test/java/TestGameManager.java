import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGameManager {

    private GameManager gameManager;

    @Before
    public void setUp() {
        Processing game = new Processing();
        gameManager = game.gameManager;
    }

    @Test
    public void testStartLevel() {

        gameManager.startLevel(1);
        assertEquals("Oxygen should be initialized based on level", 4000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(2);
        assertEquals("Oxygen should be initialized based on level", 3500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(3);
        assertEquals("Oxygen should be initialized based on level", 3000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(4);
        assertEquals("Oxygen should be initialized based on level", 2500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 2, gameManager.oxygenRate);

    }
}
