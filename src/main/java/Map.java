import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static processing.core.PApplet.print;
import static processing.core.PApplet.println;

public class Map {
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

            GameManager.gameManager.score = 0;
            GameManager.gameManager.enemies.clear();
            GameManager.gameManager.completionCount = 0;
            GameManager.gameManager.totalBatteries = 0;
            GameManager.gameManager.elapsedTime = 0;

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
                        case '1':
                            // blackhole tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.gameManager.cells[j][i].entity).id = 1;
                            break;
                        case '2':
                            // a potential second blackhole tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.gameManager.cells[j][i].entity).id = 2;
                            break;
                        case '3':
                            // a potential third blackhole tile
                            GameManager.gameManager.cells[j][i].isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.gameManager.cells[j][i].entity).id = 3;
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
