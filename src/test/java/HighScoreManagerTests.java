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


}
