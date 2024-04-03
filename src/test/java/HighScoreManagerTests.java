import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class HighScoreManagerTests {

    private Scoreboard scoreboard;
    private static final String DUMMY_SCORES_FILE_PATH = "src/test/resources/level1_scores.txt";

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }

//    @Test
//    public void testUpdateScoreboard() {
//        Scoreboard scoreboard = new Scoreboard();
//        scoreboard.updateScoreboard(100, 1);
//        assertEquals("100\n", scoreboard.getScores(1)); // Checks if the score was added to level 1
//    }

    @Test
    public void testGetScores() {
//        scoreboard.updateScoreboard(100, 1);
//        scoreboard.updateScoreboard(200, 1);
//        scoreboard.updateScoreboard(300, 1);
        assertEquals("300\n200\n100\n", scoreboard.getScores(1));
    }
    @Test
    public void testAddZeroScore() {
        String initialScores = scoreboard.getScores(1);
        scoreboard.updateScoreboard(0, 1);
        assertEquals(initialScores, scoreboard.getScores(1));
    }
    @Test
    public void testAddNegativeScore() {
        String initialScores  = scoreboard.getScores(1);
        scoreboard.updateScoreboard(-150, 1);
        assertEquals(initialScores , scoreboard.getScores(1));
    }

}
