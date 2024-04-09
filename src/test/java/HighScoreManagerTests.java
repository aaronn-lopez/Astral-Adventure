import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighScoreManagerTests {

    private Scoreboard scoreboard;

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testGetNoScores() {
        assertEquals("", scoreboard.getScores(6));
    }
    @Test
    public void testUpdateScoreboard() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScoreboard(100, 6);
        assertEquals("100\n", scoreboard.getScores(6)); // Checks if the score was added to level 1
        scoreboard.clearTestFile();
    }

    @Test
    public void testGetScores() {
        scoreboard.updateScoreboard(100, 6);
        scoreboard.updateScoreboard(200, 6);
        scoreboard.updateScoreboard(300, 6);
        assertEquals("300\n200\n100\n", scoreboard.getScores(6));
        scoreboard.clearTestFile();
    }
    @Test
    public void testAddZeroScore() {
        String initialScores = scoreboard.getScores(6);
        scoreboard.updateScoreboard(0, 6);
        assertEquals(initialScores, scoreboard.getScores(6));
        scoreboard.clearTestFile();
    }
    @Test
    public void testAddNegativeScore() {
        String initialScores  = scoreboard.getScores(6);
        scoreboard.updateScoreboard(-150, 6);
        assertEquals(initialScores , scoreboard.getScores(6));
        scoreboard.clearTestFile();
    }

}
