package game;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by ol6803ax-s on 31/08/17.
 */
public class Cell {

    private boolean alive;
    private boolean nextGen;
    private Color color;
    private Rules rules;

    Cell  (Rules rules){
        alive = false;
        color = Color.WHITE;
        nextGen = false;
        this.rules = rules;

    }

    public Color getColor(){
        return color;
    }


    public void changeStatus(){
      if(alive){
        kill();
      }
      else{
        revive();
      }
    }

    public boolean isNextGen(){
        return nextGen;
    }
    public void calculateNextGen(List<Cell> neighbors){
        nextGen = rules.calculateNextStatus(this, neighbors);
    }

    public boolean isAlive(){
      return alive;
    }

    private void revive(){
      alive = true;
      color = Color.BLACK;
    }

    private void kill(){
      alive = false;
      color = Color.WHITE;
    }
}
