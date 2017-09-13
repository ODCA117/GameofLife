package game;

import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import graphics.Tile;

/**
 * Created by ol6803ax-s on 31/08/17.
 */
public class Cell {

    private boolean alive;
    private Color color;
    private Tile tile;

    Cell(){
        alive = false;
        color = Color.WHITE;
        tile = new Tile();
        tile.changeColor(color);

        tile.setOnMouseClicked( new EventHandler<MouseEvent>(){
          @Override
          public void handle (MouseEvent event){
            if(isAlive()){
              System.out.println("Kill cell");
              kill();
            }
            else {
              System.out.println("revive cell");
              revive();
            }
          }
        });
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

    public Tile getTile(){
      return tile;
    }


    private void revive(){
      alive = true;
      color = Color.BLACK;
      tile.changeColor(color);
    }

    private void kill(){
      alive = false;
      color = Color.WHITE;
      tile.changeColor(color);
    }
}
