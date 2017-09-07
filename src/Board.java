import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * //class representing the board viewed
 */
public class Board {

    private Cell[][] cells;
    private boolean[][] willLive;
    private int side;
    private Rules rules;

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
        willLive = new boolean[side][side];
        rules = new Rules();
    }

    private Cell createCell(){
        Cell cell = new Cell();
        return cell;
    }

    /**
     * returns tile on index x, y, indexed from 0
     * @param x coordinate
     * @return Tile on (x,y)
     * @param y coordinate
     */
    public Cell getCell(int x, int y){

        return cells[x][y];
    }

    public int side(){
        return side;
    }

    public Tile getTile(int x, int y){
      return cells[x][y].getTile();
    }

    public void executeNextBoard(){

    }

    public void calculateNextBoard(){
      for(int i = 0; i < side; i++){
        for(int j = 0; j < side; j++){
          List<Cell> neighbors = getNeighbors(i,j);
          willLive[i][j] = rules.calculateNextStatus(cells[i][j], neighbors);
        }
      }
    }

    private List<Cell> getNeighbors(int y, int x) {

      System.out.println(x + " x, " + y + " j,");
      LinkedList<Cell> neighbors = new LinkedList<>();
      for(int i = y-1; i < y+2; i++ ){
        for(int j = x-1; j < x+2; j++){
          if(i >= 0 && i < side && j >= 0 && j < side){

            if(i != y || j != x){
              neighbors.add(cells[i][j]);
              System.out.println(i + " i, " + j + " j,");
            }
          }
        }
      }

      return neighbors;

    }
}
