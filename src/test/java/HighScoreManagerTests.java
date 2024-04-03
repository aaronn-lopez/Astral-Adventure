import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class HighScoreManagerTests {

    private Scoreboard scoreboard;
    private static final String DUMMY_SCORES_FILE_PATH = "src/test/resources/dummyScores.txt";

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
        loadDummyScoresFromFile();
    }

    private void loadDummyScoresFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DUMMY_SCORES_FILE_PATH));
            String line;
            int level = 1;
            // Read scores from the dummy file and update the scoreboard
            while ((line = reader.readLine()) != null) {
                scoreboard.updateScoreboard(Integer.parseInt(line), level);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void addScore() {
//        scoreboard.updateScoreboard(100, 5);
//        assertEquals("100\n", scoreboard.getScores(5));
//    }
}
