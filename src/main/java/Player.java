import processing.core.PConstants;

public class Player extends Character{
    Player(Transform transform){
        super(transform, "src/main/Sprites/Astronaut.png");
    }

    void move()
    {
        if(p.keyPressed){
            if(p.key == 'w' || p.key == 'W')
            {
                this.Transform.y -= 4;
            }
            else if(p.key == 'a' || p.key == 'A')
            {
                this.Transform.x -= 4;
            }
            else if(p.key == 's' || p.key == 'S')
            {
                this.Transform.y += 4;
            }
            else if(p.key == 'd' || p.key == 'D') {
                this.Transform.x += 4;
            }
        }
    }

    public void draw(){
        move();
        p.imageMode(PConstants.CENTER);
        p.image(this.Sprite, this.Transform.x, this.Transform.y);
    }

}
