import processing.core.PConstants;

import static processing.core.PApplet.println;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");
        println(Transform.gridX, Transform.gridY);
    }

    // If while pressing and holding one key and then press another direction and release, it will move in the second direction until first key is released
    void move(Directions direction) {
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
        }
    }

    boolean inBounds(int x, int y){
        return (x >= 0 &&
                x < GameManager.gridX &&
                y >= 0 &&
                y < GameManager.gridY) &&
                GameManager.cells[x][y].isEmpty;
    }

    public void draw(){
        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }

}
