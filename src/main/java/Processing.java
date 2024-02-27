import processing.core.PApplet;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject player;

    // Window settings
    @Override
    public void settings(){
        size(1280, 720);
    }

    // Stuff we want to do before we do the constant game update loop
    @Override
    public void setup(){
        Gameobject.init(this);
        player = new Gameobject(new Transform(500,500, 0, 1), "src/main/Sprites/Astronaut.png");
    }

    // Called once every frame
    @Override
    public void draw(){
        player.draw();
    }
}
