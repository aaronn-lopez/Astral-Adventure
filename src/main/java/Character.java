import processing.core.PConstants;

import static processing.core.PApplet.sin;

public abstract class Character extends Gameobject{

    Character(Transform transform, String spritePath){
        super(transform, spritePath);
    }

    // potentially change return type to hit gameobject for more modular collision detection
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
            if(this.getClass() == Player.class){
                GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY].player = null;
                GameManager.gameManager.cells[targetX][targetY].player = this;
            }
            else {
                GameManager.gameManager.cells[this.Transform.gridX][this.Transform.gridY].entities.remove(this);
                GameManager.gameManager.cells[targetX][targetY].entities.add(this);
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

    boolean inBounds(int x, int y){
        return (x >= 0 &&
                x < GameManager.gameManager.gridX &&
                y >= 0 &&
                y < GameManager.gameManager.gridY) &&
                GameManager.gameManager.cells[x][y].isEmpty;
    }
}
