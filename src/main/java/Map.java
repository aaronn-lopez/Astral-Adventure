import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class Map {
    int level;

    int gridX;
    int gridY;

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

            GameManager.gameManager.gridX = gridX;
            GameManager.gameManager.gridY = gridY;
            GameManager.gameManager.cells = new Cell[gridX][gridY];

            println(gridX, gridY);

            fileScanner.nextLine();

            // read each row
            for(int i = 0; i < gridY; i++){
                String mapRow = fileScanner.nextLine();
                // read each cell per row
                for(int j = 0; j < gridX; j++){
                    GameManager.gameManager.cells[j][i] = new Cell(j, i);
                    char mapTile = mapRow.toCharArray()[j];
                    switch(mapTile){
                        case 'O':
                            // empty tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            break;
                        case 'X':
                            // no tile
                            GameManager.gameManager.cells[j][i].isEmpty = false;
                            break;
                        case 'P':
                            // player tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Player, j, i);
                            break;
                        case 'W':
                            // walking alien tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.WalkingAlien, j, i);
                            break;
                        case 'H':
                            // hiding alien tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.HidingAlien, j, i);
                            break;
                        case 'T':
                            // oxygen tank tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.OxygenTank, j, i);
                            break;
                        case 'b':
                            // blackhole tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);

                            // Change this to set the id---add more cases
                            ((Blackhole)GameManager.gameManager.cells[j][i].entity).id = 0;
                            break;
                        case 'B':
                            // battery tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.gameManager.totalBatteries++;
                            GameManager.instantiate(Objects.Battery, j, i);
                            break;
                        case 'E':
                            // end tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.EndTile, j, i);
                            break;
                    }
                }
            }
        }
        catch(FileNotFoundException e){

        }
    }
}
