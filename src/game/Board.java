package game;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import javafx.scene.paint.Color;


/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * //class representing the board viewed
 */
public class Board {

    private Cell[] cells;
    private int height;
    private int width;
    private Map<Cell, List<Cell>> cellNeighbors;

    /**
     * Create squareBoard whith side side
     * @param side side of the square board
     */
    public Board (int height, int width, Rules rules) {
        this.height = height;
        this.width = width;
        cells = new Cell[height * width];

        for( int i = 0; i < cells.length; i++)
        {
            cells[i] = new Cell(rules, "(" + i/height + "," + i%width + ")");
        }

        cellNeighbors = new HashMap<>();

        for (Cell c : cells){
            List<Cell> neighbors = getNeighbors(c);
            cellNeighbors.put(c, neighbors);
        }
    }

    //create a 2-dim array with the color on each cell
    public Color[][] getCellColor(){
        Color[][] cellColor = new Color[height][width];

        for(int i = 0; i < cells.length; i++){
            cellColor[i / height][i % width] = cells[i].getColor();
        }
        return cellColor;
    }

    // change the cell status,
    // kill if alive,
    // revive if killed
    public void changeCellStatus(int x, int y){
        cells[(x * height) + y].changeStatus();

        System.out.println(cells[(x * height) + y] + " changed");
    }

    // Changes every cells status during simulation
    void executeNextBoard(){
        for(Cell c : cells){
            c.nextGen();
        }
    }

    // Calculate the next board
     void calculateNextBoard(){
        for( Cell c : cells){
            c.calculateNextGen(cellNeighbors.get(c));
        }
    }

    // Finds which neigboring cells are alive
    private List<Cell> getNeighbors(Cell c) {
        int i = findIndex(c);
        LinkedList<Cell> neighbors = new LinkedList<>();
        int size = cells.length;

        //left Neighbor
        if(i % width != 0){
            neighbors.add(cells[i - 1]);
        }

        //right neighbor
        if((i + 1) % width != 0){
            neighbors.add(cells[i + 1]);
        }

        //over Neighbor
        if(i - width >= 0){
            neighbors.add(cells[i - width]);
        }

        //under Neighbor
        if (i + width < size){
            neighbors.add(cells[i + width]);
        }

        //Left top Neighbor
        if (i % width != 0 && i - width - 1 >= 0){
            neighbors.add(cells[i - width - 1]);
        }

        //Rigt top neighbor
        if ((i + 1) % width != 0 && i - width + 1 >= 0){
            neighbors.add(cells[i - width + 1]);
        }

        //left bot Neighbor
        if(i % width != 0 && i + width - 1 < size){
            neighbors.add(cells[i + width - 1]);
        }

        //Right bot neighbor
        if (( i + 1) % width != 0 && i + width + 1 < size){
            neighbors.add(cells[i + width + 1]);
        }

        return neighbors;

    }

    //fins the index of one cell in the array
    private int findIndex(Cell c) {
        for(int i = 0; i < cells.length; i++)
            if(cells[i] == c)
                return i;
        return 0;
    }
}

