package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>Object responsible for building the map. Sets the cells in the game manager based on the read map text file.</p>
 */
public class Map {
    public int gridX;
    public int gridY;

    /**
     * <p>Load a new map into the game manager.</p>
     * @param mapFilePath path to text file containing level data.
     */
    public void newMap(String mapFilePath){
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

            GameManager.reset();

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
                            GameManager.getCell(j, i).isEmpty = true;
                            break;
                        case 'X':
                            // no tile
                            GameManager.getCell(j, i).isEmpty = false;
                            break;
                        case 'P':
                            // player tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.Player, j, i);
                            break;
                        case 'W':
                            // walking alien tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.WalkingAlien, j, i);
                            break;
                        case 'H':
                            // hiding alien tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.HidingAlien, j, i);
                            break;
                        case 'T':
                            // oxygen tank tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.OxygenTank, j, i);
                            break;
                        case '1':
                            // blackhole tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.getCell(j, i).interactable).id = 1;
                            break;
                        case '2':
                            // a potential second blackhole tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.getCell(j, i).interactable).id = 2;
                            break;
                        case '3':
                            // a potential third blackhole tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.instantiate(Objects.Blackhole, j, i);
                            ((Blackhole)GameManager.getCell(j, i).interactable).id = 3;
                            break;
                        case 'B':
                            // battery tile
                            GameManager.getCell(j, i).isEmpty = true;
                            GameManager.gameManager.totalBatteries++;
                            GameManager.instantiate(Objects.Battery, j, i);
                            break;
                        case 'E':
                            // end tile
                            GameManager.getCell(j, i).isEmpty = true;
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
