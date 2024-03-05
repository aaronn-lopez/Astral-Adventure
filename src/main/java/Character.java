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
            GameManager.cells[this.Transform.gridX][this.Transform.gridY].entity = null;
            GameManager.cells[targetX][targetY].entity = this;

            this.Transform.gridX = targetX;
            this.Transform.gridY = targetY;
            this.Transform.x = targetX * 64;
            this.Transform.y = targetY * 64;

            return true;
        }
        return false;
    }

    boolean inBounds(int x, int y){
        return (x >= 0 &&
                x < GameManager.gridX &&
                y >= 0 &&
                y < GameManager.gridY) &&
                GameManager.cells[x][y].isEmpty;
    }
}
