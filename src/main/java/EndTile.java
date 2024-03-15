import static java.lang.Math.sin;

public class EndTile extends Mapobject{

    EndTile(Transform transform){
        super(transform, "src/main/Sprites/Rocket.png");

    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }
}
