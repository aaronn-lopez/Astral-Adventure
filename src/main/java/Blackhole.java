import static java.lang.Math.sin;

public class Blackhole extends Mapobject{
    public int id;

    Blackhole(Transform transform, int id){
        super(transform, "src/main/Sprites/Blackhole.png");
        this.id = id;
    }

    public void teleport(){
        Gameobject player = GameManager.gameManager.player;
        Blackhole blackhole;

        // iterate through all cells to find matching blackhole
        for(int i = 0; i < GameManager.gameManager.gridX; i++){
            for(int j = 0; j < GameManager.gameManager.gridY; j++){
                if(GameManager.getObject(i, j) instanceof Blackhole && ((Blackhole)GameManager.getObject(i, j)).id == this.id && (GameManager.getObject(i, j)) != this){
                    blackhole = (Blackhole) GameManager.getObject(i, j);
                    if(!GameManager.gameManager.justTeleported) {
                        player.Transform.gridX = blackhole.Transform.gridX;
                        player.Transform.gridY = blackhole.Transform.gridY;
                        GameManager.gameManager.justTeleported = true;
                    }
                }
            }
        }
    }

    public void draw(){
        this.Transform.scale = (float) (1 + (sin((double) p.frameCount / 10) / 10));
        super.draw();
    }
}
