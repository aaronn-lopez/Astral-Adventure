import org.junit.Before;
import org.junit.Test;
import Game.*;

import static org.junit.Assert.assertEquals;

/**
 * Test class for leaderboard management.
 */
public class HighScoreManagerTests {

    private Scoreboard scoreboard;

    /**
     * Set up method to initialize Scoreboard.
     */
    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    /**
     * Test case for retrieving scores when no scores are available.
     */
    @Test
    public void testGetNoScores() {
        assertEquals("", scoreboard.getScores(6));
    }

    /**
     * Test case for updating the scoreboard with a new score.
     */
    @Test
    public void testUpdateScoreboard() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.updateScoreboard(100, 6);
        assertEquals("100\n", scoreboard.getScores(6)); // Checks if the score was added to level 1
        scoreboard.clearTestFile();
    }

    /**
     * Test case for retrieving scores.
     */
    @Test
    public void testGetScores() {
        int levelToTest = 6;

        scoreboard.updateScoreboard(100, levelToTest);
        scoreboard.updateScoreboard(200, levelToTest);
        scoreboard.updateScoreboard(300, levelToTest);

        String expectedOutput = "300\n200\n100\n";
        String actualOutput = scoreboard.getScores(levelToTest);

        assertEquals(expectedOutput, actualOutput);
        scoreboard.clearTestFile();
    }

    /**
     * Test case for adding a zero score.
     */
    @Test
    public void testAddZeroScore() {
        String initialScores = scoreboard.getScores(6);
        scoreboard.updateScoreboard(0, 6);
        assertEquals(initialScores, scoreboard.getScores(6));
        scoreboard.clearTestFile();
    }

    /**
     * Test case for adding a negative score.
     */
    @Test
    public void testAddNegativeScore() {
        String initialScores  = scoreboard.getScores(6);
        scoreboard.updateScoreboard(-150, 6);
        assertEquals(initialScores , scoreboard.getScores(6));
        scoreboard.clearTestFile();
    }

}
