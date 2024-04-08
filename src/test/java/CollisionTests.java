import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CollisionTests {

    private GameManager gameManager;

    @Before
    public void setUp() {
        // Create a mock for Gameobject
        Gameobject gameobjectMock = mock(Gameobject.class);

        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager
        gameManager = new GameManager();
        gameManager.startLevel(1);
    }

    @Test
    public void playerWalkingAlienCollision() {
        Gameobject player = gameManager.player;

        // Create a walking alien object
        GameManager.instantiate(Objects.WalkingAlien, player.Transform.gridX, player.Transform.gridY);

        // Perform collision check
        ((Player)player).checkCollisions();

        int afterOxygen = gameManager.oxygen;
        assertEquals(0, afterOxygen);
    }

    @Test
    public void playerSpikeCollision() {
        Gameobject player = gameManager.player;
        int beforeOxygen = gameManager.oxygen;

        // Create a spike object
        GameManager.instantiate(Objects.HidingAlien, player.Transform.gridX, player.Transform.gridY);

        // Perform collision check
        ((Player)player).checkCollisions();

        int afterOxygen = gameManager.oxygen;
        assertEquals(beforeOxygen - 480, afterOxygen);
    }

    @Test
    public void playerBatteryCollision() {
        Gameobject player = gameManager.player;

        // Create a battery object
        GameManager.instantiate(Objects.Battery, player.Transform.gridX, player.Transform.gridY);

        // Perform collision check
        ((Player)player).checkCollisions();

        int afterCompletionCount = gameManager.completionCount;
        assertEquals(1, afterCompletionCount);
    }

    @Test
    public void playerOxygenTankCollision() {
        Gameobject player = gameManager.player;

        // remove some oxygen so that the tank can refill it
        gameManager.oxygen -= 100;

        // Create an oxygen tank object
        GameManager.instantiate(Objects.OxygenTank, player.Transform.gridX, player.Transform.gridY);

        // Perform collision check
        ((Player)player).checkCollisions();

        int afterOxygen = gameManager.oxygen;
        assertEquals(4000, afterOxygen);
    }

    @Test
    public void playerBlackholeCollision(){
        Gameobject player = gameManager.player;
        // move player to blackhole
        player.setPosition(5,3);

        ((Player)player).checkCollisions();

        // check to see if the player got teleported
        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {12, 3});
    }

    @Test
    public void playerMoveTestWall(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Left);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {3, 2});
    }

    @Test
    public void playerMoveTestFreeSpace(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Right);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {4, 2});
    }

    @Test
    public void enemyPatrol(){
        Player player = (Player)gameManager.player;

        GameManager.instantiate(Objects.WalkingAlien, 5, 2);
        WalkingAlien enemy = (WalkingAlien)GameManager.getEnemy(5, 2);
        enemy.Patrol();

        assertArrayEquals(new int[] {4, 2}, new int[] {enemy.Transform.gridX, enemy.Transform.gridY});
    }

}
