import Game.GameManager;
import org.junit.Before;
import org.junit.Test;
import Game.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class for collision interactions between game objects.
 */
public class CollisionTests {

    private GameManager gameManager;

    /**
     * Set up method to initialize the game environment for collision tests.
     */
    @Before
    public void setUp() {
        // Create a mock for Gameobject
        Gameobject gameobjectMock = mock(Gameobject.class);

        // Mock the static init method
        Gameobject.init(mock(Processing.class));

        // Initialize GameManager.GameManager
        gameManager = new GameManager();
        gameManager.startLevel(1);
    }

    /**
     * Test case for collision between player and walking alien.
     */
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

    /**
     * Test case for collision between player and spike.
     */
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

    /**
     * Test case for collision between player and battery.
     */
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

    /**
     * Test case for collision between player and oxygen tank.
     */
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

    /**
     * Test case for collision between player and black hole.
     */
    @Test
    public void playerBlackholeCollision(){
        Gameobject player = gameManager.player;
        // move player to blackhole
        player.setPosition(5,3);

        ((Player)player).checkCollisions();

        // check to see if the player got teleported
        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {12, 3});
    }

    /**
     * Test case for player movement against a wall.
     */
    @Test
    public void playerMoveTestWall(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Left);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {3, 2});
    }

    /**
     * Test case for player movement in free space.
     */
    @Test
    public void playerMoveTestFreeSpace(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Right);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {4, 2});
    }

    /**
     * Test case for player movement against a wall upwards.
     */
    @Test
    public void playerMoveUpWall(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Up);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {3, 2});
    }

    /**
     * Test case for player movement downwards in empty space.
     */
    @Test
    public void playerMoveDownEmpty(){
        Player player = (Player)gameManager.player;
        player.move(Directions.Down);

        assertArrayEquals(new int[] {player.Transform.gridX, player.Transform.gridY}, new int[] {3, 3});
    }

    /**
     * Test case for enemy patrolling to the left.
     */
    @Test
    public void enemyPatrolLeft(){
        Player player = (Player)gameManager.player;

        GameManager.instantiate(Objects.WalkingAlien, 5, 2);
        WalkingAlien enemy = (WalkingAlien)GameManager.getEnemy(5, 2);
        enemy.Patrol();

        assertArrayEquals(new int[] {4, 2}, new int[] {enemy.Transform.gridX, enemy.Transform.gridY});
    }

    /**
     * Test case for enemy patrolling to the right.
     */
    @Test
    public void enemyPatrolRight(){
        Player player = (Player)gameManager.player;

        player.setPosition(5, 4);

        GameManager.instantiate(Objects.WalkingAlien, 3, 3);
        WalkingAlien enemy = (WalkingAlien)GameManager.getEnemy(3, 3);
        enemy.Patrol();

        assertArrayEquals(new int[] {4, 3}, new int[] {enemy.Transform.gridX, enemy.Transform.gridY});
    }

    /**
     * Test case for enemy patrolling upwards.
     */
    @Test
    public void enemyPatrolUp(){
        Player player = (Player)gameManager.player;

        GameManager.instantiate(Objects.WalkingAlien, 3, 4);
        WalkingAlien enemy = (WalkingAlien)GameManager.getEnemy(3, 4);
        enemy.Patrol();

        assertArrayEquals(new int[] {3, 3}, new int[] {enemy.Transform.gridX, enemy.Transform.gridY});
    }

    /**
     * Test case for enemy patrolling downwards.
     */
    @Test
    public void enemyPatrolDown(){
        Player player = (Player)gameManager.player;
        player.setPosition(3, 4);

        GameManager.instantiate(Objects.WalkingAlien, 3, 2);
        WalkingAlien enemy = (WalkingAlien)GameManager.getEnemy(3, 2);
        enemy.Patrol();

        assertArrayEquals(new int[] {3, 3}, new int[] {enemy.Transform.gridX, enemy.Transform.gridY});
    }

}
