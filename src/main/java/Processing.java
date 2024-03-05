import processing.core.PApplet;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    GameManager gameManager;
    Map testingMap;
    Player player;

    // Window settings
    @Override
    public void settings(){
        size(1280, 720);
    }

    // Stuff we want to do before we do the constant game update loop
    @Override
    public void setup() {
        // send static reference of the PApplet
        Gameobject.init(this);
        testingMap = new Map();
        testingMap.newMap("src/main/java/TestingMap1.txt");

        player = (Player)GameManager.cells[testingMap.playerPos[0]][testingMap.playerPos[1]].entity;

        GameManager.updateMap(testingMap);

        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");
    }

    // Called once every frame
    @Override
    public void draw(){
        bg.draw();

        for(int pass = 0; pass < 3; pass++) {
            for (int i = 0; i < GameManager.gridX; i++) {
                for (int j = 0; j < GameManager.gridY; j++) {
                    if (GameManager.cells[i][j].isEmpty) {
                        GameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        for(int i = 0; i < GameManager.gridX; i++){
            for(int j = 0; j < GameManager.gridY; j++){
                if(GameManager.cells[i][j].entity != null && GameManager.cells[i][j].isEmpty) {
                    GameManager.cells[i][j].entity.draw();
                }
            }
        }
        //alien1.Patrol();
        //alien2.Patrol();
    }

    @Override
    public void keyPressed(){
        switch(key){
            case 'w':
                player.move(Directions.Up);
                break;
            case 'd':
                player.move(Directions.Right);
                break;
            case 's':
                player.move(Directions.Down);
                break;
            case 'a':
                player.move(Directions.Left);
                break;
        }
    }
}