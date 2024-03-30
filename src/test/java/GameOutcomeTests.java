import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class GameOutcomeTests {

    private GameManager gameManager;

    @Before
    public void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void playerRunsOutOfOxygen_gameEndsInLoss() {
        // Create mock listener
        GameEndListener listenerMock = Mockito.mock(GameEndListener.class);
        gameManager.addGameEndListener(listenerMock);

        // Set the player's oxygen to 0
        gameManager.oxygen = 0;

        // Check for game end conditions
        gameManager.checkForGameEnd();

        // Verify that the listener is notified with a loss
        verify(listenerMock).onGameEnd(false);
    }
}