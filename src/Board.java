import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * //class representing the board viewed
 */
public class Board {

    private Cell[][] cells;
    private int side;


    /**
     * Create squareBoard whith side side
     * @param side side of the square board
     */
    public Board (int side) {
        cells = new Cell[side][side];
        this.side = side;

        for (int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                cells[i][j] = createCell();
            }
        }
    }

    private Cell createCell(){
        Cell cell = new Cell();

        return cell;
    }

    /**
     * returns tile on index x, y, indexed from 0
     * @param x coordinate
     * @param y coordinate
     * @return Tile on (x,y)
     */
    public Cell getCell(int x, int y){

        return cells[x][y];
    }

    public int side(){
        return side;
    }



}
