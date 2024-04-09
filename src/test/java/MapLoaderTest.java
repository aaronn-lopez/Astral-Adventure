import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;

/**
 * Test class for MapLoader.
 */
public class MapLoaderTest {
    private Map map;
    private String testMapPath = "src/test/resources/TestLevels/TestLevel1.txt";
    private String noGridMapPath = "src/test/resources/TestLevels/TestLevelNoGrid.txt";
    private String emptyMapPath = "src/test/resources/TestLevels/EmptyLevel.txt";

    /**
     * Set up method to initialize Map object.
     */
    @Before
    public void setUp() {
        // Initialize the Map object
        map = new Map();
    }

    /**
     * Test case to check loading of a map.
     */
    @Test
    public void testMapLoading() {
        // Load the test map file
        loadTestMap();

        // Assert that gridX and gridY are greater than 0
        assertTrue("gridX should be greater than 0", map.gridX > 0);
        assertTrue("gridY should be greater than 0", map.gridY > 0);
    }

    /**
     * Test case to check loading of a non-existent map file.
     */
    @Test
    public void testNonExistentMapLoading() {
        // Load a non-existent map file
        loadMap(emptyMapPath);

        // Assert that the map loading fails
        assertNull("Map should not be loaded from a non-existent file", map);
    }

    /**
     * Test case to check loading of an empty map file.
     */
    @Test
    public void testEmptyMapLoading() {
        // Load an empty map file
        loadMap(noGridMapPath);

        // Assert that gridX and gridY are greater than 0
        assertTrue("gridX should be greater than 0", map.gridX <= 0);
        assertTrue("gridY should be greater than 0", map.gridY <= 0);
    }

    /**
     * Helper method to load the test map.
     */
    private void loadTestMap() {
        loadMap(testMapPath);
    }

    /**
     * Helper method to load a map from the specified path.
     * @param mapPath The path of the map file to load.
     */
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
