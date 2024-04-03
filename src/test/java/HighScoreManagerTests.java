import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class HighScoreManagerTests {

    private Scoreboard scoreboard;

    @Before
    public void setUp() {
        scoreboard = new Scoreboard();
    }
}
