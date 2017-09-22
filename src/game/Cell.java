package game;

import javafx.scene.paint.Color;

/**
 * Created by ol6803ax-s on 31/08/17.
 */
public class Cell {

    private boolean alive;
    private Color color;

    Cell(){
        alive = false;
        color = Color.WHITE;
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
