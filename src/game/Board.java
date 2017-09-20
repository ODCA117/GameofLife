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

    private Cell[][] cells;
    private boolean[][] willLive;// Flytta till Cell
    private Rules rules; //Flytta till MainApplication

    /**
     * Create squareBoard whith side side
     * @param side side of the square board
     */
    public Board (int side) {
        cells = new Cell[side][side];

        for (int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                cells[i][j] = createCell();
            }
        }
        willLive = new boolean[side][side];
        rules = new Rules();
    }

    private Cell createCell(){
        Cell cell = new Cell();
        return cell;
    }

    public Color[][] getCellColor(){
        Color[][] cellColor = new Color[cells.length][cells.length];

        for (int i = 0; i < cellColor.length; i++){
            for(int j = 0; j < 0; j++){
                cellColor[i][j] = cells[i][j].getColor();
            }
        }

        return cellColor;
    }

    public void changeCellStatus(int x, int y){
        cells[x][y].changeStatus();
    }


    //Flytta på så att graphics ej kommer åt detta
    public void executeNextBoard(){
      for(int i = 0; i < cells.length; i++){
        for(int j = 0; j < cells.length; j++){
          if( willLive[i][j] != cells[i][j].isAlive()){
            cells[i][j].changeStatus();
          }
        }
      }
    }

    //Flytta på så att graphics ej kommer åt detta
    public void calculateNextBoard(){
      for(int i = 0; i < cells.length; i++){
        for(int j = 0; j < cells.length; j++){
          List<Cell> neighbors = getNeighbors(i,j);
          willLive[i][j] = rules.calculateNextStatus(cells[i][j], neighbors);
        }
      }
    }

    private List<Cell> getNeighbors(int y, int x) {

      LinkedList<Cell> neighbors = new LinkedList<>();
      for(int i = y-1; i < y+2; i++ ){
        for(int j = x-1; j < x+2; j++){
          if(i >= 0 && i < cells.length && j >= 0 && j < cells.length){
            if(i != y || j != x){
              neighbors.add(cells[i][j]);
            }
          }
        }
      }

      return neighbors;

    }
}
