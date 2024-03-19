/**
 * <p>Abstract class for moving entities, such as the player, and the walking alien.</p>
 */
public abstract class Character extends Gameobject{

    Character(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    /**
     * <p></p>
     * @param direction Direction to move the object
     * @return returns true if movement is successful, false otherwise
     */
    boolean move(Directions direction) {
        int targetX = this.Transform.gridX;
        int targetY = this.Transform.gridY;

        switch(direction){
            case Directions.Up:
                targetY -= 1;
                break;
            case Directions.Down:
                targetY += 1;
                break;
            case Directions.Right:
                targetX += 1;
                break;
            case Directions.Left:
                targetX -= 1;
                break;
        }

        if (inBounds(targetX, targetY)) {
            if(this instanceof Player){
                GameManager.getCell(this.Transform.gridX, this.Transform.gridY).player = null;
                GameManager.getCell(targetX, targetY).player = this;
            }
            else {
                if(this instanceof WalkingAlien && GameManager.getEnemy(targetX, targetY) != null){
                    return false;
                }

                GameManager.getCell(this.Transform.gridX, this.Transform.gridY).enemy = null;
                GameManager.getCell(targetX, targetY).enemy = this;
            }

            this.Transform.gridX = targetX;
            this.Transform.gridY = targetY;
            this.Transform.x = targetX * 64;
            this.Transform.y = targetY * 64;

            if(this instanceof Player){
                GameManager.gameManager.justTeleported = false;
            }

            return true;
        }
        return false;
    }

    /**
     * <p>Private method for determining if the player is on a walkable tile (not accounting for entities on the tile)</p>
     * @param x grid X position of the object
     * @param y grid Y position of the object
     * @return returns true if the object is in bounds, false otherwise.
     */
    private boolean inBounds(int x, int y){
        return (x >= 0 &&
                x < GameManager.gameManager.gridX &&
                y >= 0 &&
                y < GameManager.gameManager.gridY) &&
                GameManager.gameManager.cells[x][y].isEmpty;
    }
}
