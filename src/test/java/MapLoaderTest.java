import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MapLoaderTest {
    private Map map;
    private String testMapPath = "src/test/resources/TestLevels/TestLevel1.txt";
    private String noGridMapPath = "src/test/resources/TestLevels/TestLevelNoGrid.txt";
    private String emptyMapPath = "src/test/resources/TestLevels/EmptyLevel.txt";

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

    @Test
    public void testNonExistentMapLoading() {
        // Load a non-existent map file
        loadMap(emptyMapPath);

        // Assert that the map loading fails
        assertNull("Map should not be loaded from a non-existent file", map);
    }

    @Test
    public void testEmptyMapLoading() {
        // Load an empty map file
        loadMap(emptyMapPath);

        // Assert that the map loading fails
        assertNull("Map should not be loaded from an empty file", map);
    }

    private void loadTestMap() {
        loadMap(testMapPath);
    }

    private void loadMap(String mapPath) {
        try {
            File mapFile = new File(mapPath);
            Scanner fileScanner = new Scanner(mapFile);
            map.gridX = fileScanner.nextInt();
            map.gridY = fileScanner.nextInt();
            fileScanner.close();
        } catch (Exception e) {
            map = null; // Set map to null if loading fails
        }
    }
}
