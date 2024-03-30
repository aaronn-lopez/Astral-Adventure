//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class CollisionTests {
//
//    private GameManager gameManager;
//
//    @Before
//    public void setUp() {
//        // Create a mock for Gameobject
//        Gameobject gameobjectMock = mock(Gameobject.class);
//
//        // Mock the static init method
//        Gameobject.init(mock(Processing.class));
//
//        // Initialize GameManager
//        gameManager = new GameManager();
//    }
//
//    @Test
//    public void playerWalkingAlienCollision() {
//        // Create a player object
//        Player playerMock = new Player(new Transform(0, 0, 0, 0));
//
//        // Create a walking alien object
//        WalkingAlien alienMock = new WalkingAlien(new Transform(0, 0, 0, 0));
//
//        // Add the alien to the GameManager's enemies list
//        gameManager.enemies.add(alienMock);
//
//        // Perform collision check
//        playerMock.checkCollisions();
//
//        // Verify that decreaseOxygen method is called on the alienMock
//        verify(alienMock).decreaseOxygen();
//    }
//}
