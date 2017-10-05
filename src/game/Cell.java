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
    private String name;

    Cell  (Rules rules, String name){
        alive = false;
        color = Color.WHITE;
        nextGen = false;
        this.rules = rules;
        this.name = name;

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

    public void calculateNextGen(List<Cell> neighbors){
        nextGen = rules.calculateNextStatus(this, neighbors);
    }

    public boolean isAlive(){
      return alive;
    }

    public void nextGen(){
        if(nextGen){
            revive();
        }

        else{
            kill();
        }
    }

    @Override
    public String toString () {
        return name;
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
