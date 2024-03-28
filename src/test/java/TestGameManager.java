import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import processing.core.PApplet;

//// Program entry point
//public class Main {
//    // Call the processing class to begin the game loop
//    public static void main(String[] args){
//        PApplet.main(Processing.class.getName());
//    }
//}

public class TestGameManager {

    /* I always get this error:
     Errors:
     TestGameManager.testStartLevel:18 ┬╗ NullPointer Cannot invoke "processing.core.PApplet.loadImage(String)" because "Gameobject.p" is null
    */
    private GameManager gameManager;

    @Before
    public void setUp() {
        PApplet.main(Processing.class.getName());
        gameManager = new GameManager();
    }

    @Test
    public void testStartLevel() {

        gameManager.startLevel(1);
        assertEquals("Oxygen should be initialized based on level", 4000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(2);
        assertEquals("Oxygen should be initialized based on level", 3500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(3);
        assertEquals("Oxygen should be initialized based on level", 3000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 1, gameManager.oxygenRate);

        gameManager.startLevel(4);
        assertEquals("Oxygen should be initialized based on level", 2500, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 2, gameManager.oxygenRate);

        gameManager.startLevel(5);
        assertEquals("Oxygen should be initialized based on level", 2000, gameManager.oxygen);
        assertEquals("Oxygen rate should be initialized based on level", 2, gameManager.oxygenRate);

    }
}
