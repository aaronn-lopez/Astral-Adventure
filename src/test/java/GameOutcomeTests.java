import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameOutcomeTests {

    private GameManager gameManager;

    @Before
    public void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void playerRunsOutOfOxygen() {
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

//    @Test
//    public void playerHas1_Oxygen() {
//        GameEndListener listenerMock = Mockito.mock(GameEndListener.class);
//        gameManager.addGameEndListener(listenerMock);
//
//        gameManager.oxygen = 1;
//
//        gameManager.checkForGameEnd();
//
//        verify(listenerMock).onGameEnd(true);
//    }
}