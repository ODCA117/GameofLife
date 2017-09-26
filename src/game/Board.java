package game;

import java.util.List;
import java.util.LinkedList;


import javafx.scene.paint.Color;


/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * //class representing the board viewed
 */
public class Board {

    private Cell[] cells;
    private int side;
    private boolean[] willLive;// Flytta till Cell
    private Rules rules; //Flytta till MainApplication

    /**
     * Create squareBoard whith side side
     * @param side side of the square board
     */
    public Board (int side, Rules rules) {
        this.side = side;
        this.rules = rules;
        cells = new Cell[side * side];

        for( int i = 0; i < cells.length; i++)
        {
            cells[i] = new Cell(rules);
        }

        willLive = new boolean[side * side];
    }

    //create a 2-dim array with the collor on each cell
    public Color[][] getCellColor(){
        Color[][] cellColor = new Color[side][side];

        for(int i = 0; i < cells.length; i++){
            cellColor[i/side][i%side] = cells[i].getColor();
        }
        return cellColor;
    }

    // change the cell status,
    // kill if alive,
    // revive if killed
    public void changeCellStatus(int x, int y){
        cells[(x * side) + y].changeStatus();
    }

    // Changes every cells status during simulation
    void executeNextBoard(){
        for(Cell c : cells){
            if(c.isNextGen())
                c.changeStatus();
        }
    }

    // Calculate the next board
     void calculateNextBoard(){

        for( Cell c : cells){
            List<Cell> neighbors = getNeighbors(c);
            c.calculateNextGen(neighbors);
        }

    }

    // Finds which neigboring cells are alive
    private List<Cell> getNeighbors(Cell c) {
        int index = findIndex(c);
        LinkedList<Cell> neighbors = new LinkedList<>();

        for(int i = -1; i <= 1; i++){
           for( int j = -1; j <= 1; j++){
               int row = index/side + i;
               int col = index%side + j;

               if(row > 0 && row > side){

               }
               else if(col < 0 && col > side){

               }

               else if( cells[row + col].isAlive()){
                   neighbors.add(cells[row + col]);
               }
           }

        }

        return neighbors;

    }

    //fins the index of one cell in the array
    private int findIndex(Cell c) {
        for(int i=0; i<cells.length; i++)
            if(cells[i] == c)
                return i;
        return 0;
    }
}

