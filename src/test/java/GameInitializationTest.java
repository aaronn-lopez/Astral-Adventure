import org.junit.Test;
import static org.junit.Assert.*;

public class GameInitializationTest {

    @Test
    public void testGameInitialization() {
        Processing game = new Processing();
        assertNotNull(game.gameManager);
        assertNotNull(game.guiManager);
    }
}
