import static java.lang.Math.sin;

public class Blackhole extends Mapobject{
    public int id;

    Blackhole(Transform transform, int id){
        super(transform, "src/main/Sprites/Blackhole.png");
        this.id = id;
    }

    public void teleport(){

    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }
}
