import Game.GameManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import Game.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class for GameOutcomeTests.
 */
public class GameOutcomeTests {

    private GameManager gameManager;

    /**
     * Set up method to initialize GameManager.GameManager.
     */
    @Before
    public void setUp() {
        gameManager = new GameManager();
    }

    /**
     * Test case for player running out of oxygen.
     */
    @Test
    public void playerRunsOutOfOxygen() {
        // Create mock listener
        GameEndListener listenerMock = Mockito.mock(GameEndListener.class);
        gameManager.addGameEndListener(listenerMock);

        // Set the player's oxygen to 0
        gameManager.currentOxygen = 0;

        // Check for game end conditions
        gameManager.checkForGameEnd();

        // Verify that the listener is notified with a loss
        verify(listenerMock).onGameEnd(false);
    }

    /**
     * Test case for player having sufficient oxygen with enough batteries and reaching the end tile.
     */
    @Test
    public void playerHas1_Oxygen() {
        GameEndListener listenerMock = Mockito.mock(GameEndListener.class);
        gameManager.addGameEndListener(listenerMock);
        gameManager.startLevel(1);

        gameManager.collectedBatteries = 3;

        GameManager.instantiate(Objects.EndTile, gameManager.player.Transform.gridX, gameManager.player.Transform.gridY);

        gameManager.checkForGameEnd();

        verify(listenerMock).onGameEnd(true);
    }
}