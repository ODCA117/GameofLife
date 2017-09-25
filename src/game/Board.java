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
        this.side = side - 1;
        this.rules = rules;
        cells = new Cell[side * side];

        for( Cell c : cells){
            c = new Cell(rules);
        }
        willLive = new boolean[side * side];

    }

    public Color[][] getCellColor(){
        Color[][] cellColor = new Color[side][side];

        for(int i = 0; i < cells.length; i++){
            cellColor[i/side][i%side] = cells[i].getColor();
        }

        return cellColor;
    }

    public void changeCellStatus(int x, int y){
        cells[(x * side) + y].changeStatus();
    }

    //Flytta på så att graphics ej kommer åt detta
    void executeNextBoard(){
        for(Cell c : cells){
            if(c.isNextGen())
                c.changeStatus();
        }
    }

    //Flytta på så att graphics ej kommer åt detta
     void calculateNextBoard(){

        for( Cell c : cells){
            List<Cell> neighbors = getNeighbors(c);
            c.calculateNextGen(neighbors);
        }

    }

    //Gör om för endim
    private List<Cell> getNeighbors(Cell c) {
        int index = findIndex(c);
        LinkedList<Cell> neighbors = new LinkedList<>();

        for(int i = -1; i <= 1; i++){
           for( int j = -1; j <= 1; j++){
               int row = index/side + i;
               int col = index%side + j;

               if(row < 0 && row > side){

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

    private int findIndex(Cell c) {
        for(int i=0; i<cells.length; i++)
            if(cells[i] == c)
                return i;
    }
}

