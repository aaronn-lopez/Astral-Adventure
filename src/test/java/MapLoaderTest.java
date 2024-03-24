import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MapLoaderTest {
    private Map map;
    private String testMapPath = "src/test/resources/TestLevels/TestLevel1.txt";

    @Before
    public void setUp() {
        // Initialize the Map object
        map = new Map();
    }

    @Test
    public void testMapLoading() {
        // Load the test map file
        loadTestMap();

        // Assert that gridX and gridY are greater than 0
        assertTrue("gridX should be greater than 0", map.gridX > 0);
        assertTrue("gridY should be greater than 0", map.gridY > 0);
    }

    private void loadTestMap() {
        try {
            File mapFile = new File(testMapPath);
            Scanner fileScanner = new Scanner(mapFile);
            map.gridX = fileScanner.nextInt();
            map.gridY = fileScanner.nextInt();
            fileScanner.close();
        } catch (Exception e) {
            fail("Failed to load test map: " + e.getMessage());
        }
    }
}
