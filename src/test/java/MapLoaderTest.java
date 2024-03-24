import org.junit.Test;
import static org.junit.Assert.*;

public class MapLoaderTest {

    @Test
    public void testMapLoading() {
        Map map = new Map();

        String testMapPath = "src/test/resources/TestLevels/TestLevel1.txt";
        map.newMap(testMapPath);

        assertTrue("gridX should be greater than 0", map.gridX > 0);
        assertTrue("gridY should be greater than 0", map.gridY > 0);
    }
}
