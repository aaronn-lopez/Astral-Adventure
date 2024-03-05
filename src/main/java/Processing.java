import processing.core.PApplet;

// Pseudo 'main' class---where we want to do our logic programming
public class Processing extends PApplet {
    Gameobject bg;
    GameManager gameManager;
    Map testingMap;
    Player player;
    WalkingAlien alien;

    int numRows = 16;
    int numCols = 10;

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
        gameManager = new GameManager();
        testingMap = new Map(16, 10);

        gameManager.updateMap(testingMap);


        player = (Player)gameManager.instantiate(Objects.Player, 15, 9);
        alien = (WalkingAlien)gameManager.instantiate(Objects.WalkingAlien, 1, 1);
        gameManager.instantiate(Objects.Battery, 4, 4);
        gameManager.instantiate(Objects.Blackhole, 7, 7);


        bg = new Gameobject(new Transform(640, 360, 0, 1), "src/main/Sprites/Space Background.png");
    }

    // Called once every frame
    @Override
    public void draw(){
        //frameRate(1);
        bg.draw();

        for(int pass = 0; pass < 3; pass++) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    GameManager.cells[i][j].isEmpty = j % 5 != 0 && i % 8 != 0;

                    if (GameManager.cells[i][j].isEmpty) {
                        GameManager.cells[i][j].drawTile(pass);
                    }
                }
            }
        }

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(GameManager.cells[i][j].entity != null && GameManager.cells[i][j].isEmpty) {
                    GameManager.cells[i][j].entity.draw();
                }
            }
        }
        alien.Patrol();
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