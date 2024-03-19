/**
 * <p>Class to store information about any given cell on the game board. Includes references to objects on the given cell.</p>
 */
public class Cell {
    int x;
    int y;

    boolean isEmpty = false; // determines if a given cell can be walked on--empty cells behave like walls

    Gameobject interactable;
    Gameobject enemy;
    Gameobject[] tile;
    Gameobject player;

    String pathSprite = "src/main/Sprites/Path.png";
    String outlineSprite = "src/main/Sprites/Path Outline.png";
    String cliffSprite = "src/main/Sprites/Path Cliff.png";

    Cell(int x, int y){
        this.x = x;
        this.y = y;

        // the three 'layers' of each tile
        tile = new Gameobject[3];
        tile[0] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), cliffSprite);
        tile[1] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), outlineSprite);
        tile[2] = new Gameobject(new Transform(x * 64, y * 64, 0, 1), pathSprite);
    }

    /**
     * <p>Method for drawing the cell tile. Call once for each pass in order to properly render the tiles in order.</p>
     * @param drawPass 1-3
     */
    void drawTile(int drawPass){
        tile[drawPass].draw();
    }
}
