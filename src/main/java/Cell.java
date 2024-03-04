public class Cell {
    int x;
    int y;

    boolean isEmpty = false; // determines if a given cell can be walked on--empty cells behave like walls

    Gameobject entity; // gameobject contents--0,1
    Gameobject[] tile;

    String pathSprite = "src/main/Sprites/Path.png";
    String outlineSprite = "src/main/Sprites/Path Outline.png";
    String cliffSprite = "src/main/Sprites/Path Cliff.png";

    Cell(int x, int y){
        this.x = x;
        this.y = y;

        tile = new Gameobject[3];
        tile[0] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), cliffSprite);
        tile[1] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), outlineSprite);
        tile[2] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), pathSprite);
    }

    void addTile(){

    }

    void addEntity(){

    }

    // call draw tile 3 times to draw each layer at a time
    void drawTile(int drawPass){
        tile[drawPass].draw();
    }
}
