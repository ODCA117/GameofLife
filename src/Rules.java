/**
 * Created by ol6803ax-s on 31/08/17.
 */
public class Rules {

    Rules (){

    }
//other comments
    public boolean calculateNextStatus(Cell cell, List<Cell> neighbors){
      int aliveNeighbors = numberOfNeighbors(neighbors);

      if (aliveNeighbors < 2 && cell.isAlive()){
        return false;
      }
      else if(aliveNeighbors > 3 && cell.isAlive()){
        return false;
      }

      else if(cell.isAlive()){
        return true;
      }

      else if(aliveNeighbors == 3 && !cell.isAlive()){
        return true;
      }
      else {
        return false;
      }
    }

    private int numberOfNeighbors(List<Cell> neighbors){
      int aliveNeighbors = 0;
      for (int i;i < neighbors.size(); i++ ) {
        if(neighbors.remove(0).isAlive){
          aliveNeighbors++;
        }
      }
    }
}
