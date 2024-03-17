public class WalkingAlien extends Alien{
    WalkingAlien(Transform transform){
        super(transform, "src/main/Sprites/Slime.png");
    }

    public Directions dir;
    void Patrol() {
        int playerX = GameManager.gameManager.player.Transform.gridX;
        int playerY = GameManager.gameManager.player.Transform.gridY;

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

    //If you hit a Walking Alien, you lose 25 seconds or 25% of oxygen
    @Override
    public void decreaseOxygen() {
        GameManager.gameManager.oxygen -= 480 * 5;

    }
}
