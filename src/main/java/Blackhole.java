import static java.lang.Math.sin;

/**
 * <p>Blackhole object that teleports the player to the connected blackhole of the same ID.</p>
 */
public class Blackhole extends Mapobject{
    public int id;

    Blackhole(Transform transform, int id){
        super(transform, "src/main/Sprites/Blackhole.png");
        this.id = id;
    }

    /**
     * <p>Teleports the player to the corresponding blackhole on the game board.</p>
     */
    public void teleport(){
        Gameobject player = GameManager.gameManager.player;
        Blackhole blackhole;

        // iterate through all cells to find matching blackhole
        for(int i = 0; i < GameManager.gameManager.gridX; i++){
            for(int j = 0; j < GameManager.gameManager.gridY; j++){
                if(GameManager.getObject(i, j) instanceof Blackhole && ((Blackhole)GameManager.getObject(i, j)).id == this.id && (GameManager.getObject(i, j)) != this){
                    blackhole = (Blackhole) GameManager.getObject(i, j);
                    // check if the player has just teleported, to avoid going back and forth instantly
                    if(!GameManager.gameManager.justTeleported) {
                        player.setPosition(blackhole.Transform.gridX, blackhole.Transform.gridY);
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
