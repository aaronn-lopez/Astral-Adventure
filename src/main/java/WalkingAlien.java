public class WalkingAlien extends Enemy {
    WalkingAlien(Transform transform){
        super(transform, "src/main/Sprites/Slime.png");
    }

    public Directions dir;

    /**
     * <p>Set the enemy's direction to move towards the player.</p>
     */
    void Patrol() {
        int playerX = GameManager.gameManager.player.Transform.gridX;
        int playerY = GameManager.gameManager.player.Transform.gridY;

        // move towards the player
        if (playerX < this.Transform.gridX) {
            dir = Directions.Left;
        } else if (playerX > this.Transform.gridX) {
            dir = Directions.Right;
        } else if (playerY < this.Transform.gridY) {
            dir = Directions.Up;
        } else if (playerY > this.Transform.gridY) {
            dir = Directions.Down;
        }

        move(dir);
    }

    //If you hit a Walking Alien, the game ends
    @Override
    public void decreaseOxygen() {
        GameManager.gameManager.oxygen = 0;

    }
}
