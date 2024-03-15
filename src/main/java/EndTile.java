import static java.lang.Math.sin;

public class EndTile extends Mapobject{
    public int id;

    EndTile(Transform transform, int id){
        super(transform, "src/main/Sprites/Spike.png");
        this.id = id;
    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }
}
