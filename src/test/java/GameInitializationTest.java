import org.junit.Test;
import static org.junit.Assert.*;
import Game.*;

/**
 * Test class for checking game initialization.
 */
public class GameInitializationTest {

    /**
     * Test case to verify game initialization.
     */
    @Test
    public void testGameInitialization() {
        // Test logic
        Processing game = new Processing();
        assertNotNull(game.gameManager);
        assertNotNull(game.guiManager);
    }
}
