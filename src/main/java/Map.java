import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class Map {
    int level;

    int gridX;
    int gridY;

    int[] playerPos;

    Map(){
        playerPos = new int[2];
    }

    void newMap(String mapFilePath){
        // MAP TEXT FORMAT
        // [int gridX]
        // [int gridY]
        // XXXOOOXXXX
        // XXXOOXXXXO
        // etc...

        // read map contents from text file
        try {
            File mapFile = new File(mapFilePath);
            Scanner fileScanner = new Scanner(mapFile);
            gridX = fileScanner.nextInt();
            gridY = fileScanner.nextInt();

            GameManager.gridX = gridX;
            GameManager.gridY = gridY;
            GameManager.cells = new Cell[gridX][gridY];

            println(gridX, gridY);

            fileScanner.nextLine();

            // read each row
            for(int i = 0; i < gridY; i++){
                String mapRow = fileScanner.nextLine();
                // read each cell per row
                for(int j = 0; j < gridX; j++){
                    GameManager.cells[j][i] = new Cell(j, i);
                    char mapTile = mapRow.toCharArray()[j];
                    switch(mapTile){
                        case 'O':
                            // empty tile
                            GameManager.cells[j][i].isEmpty = true;
                            break;
                        case 'X':
                            // no tile
                            GameManager.cells[j][i].isEmpty = false;
                            break;
                        case 'P':
                            // player tile
                            GameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Player, j, i);
                            playerPos[0] = j; playerPos[1] = i;
                            break;
                    }
                }
            }
        }
        catch(FileNotFoundException e){

        }
    }
}
