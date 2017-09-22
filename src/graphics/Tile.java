package graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * Representing the Graphics.Tile;
 * contains color of the tile and size;
 */
public class Tile extends Rectangle{


    public Tile (){
        super(25,25);
        this.setFill(Color.WHITE);
    }

    public void changeColor(Color color){
        this.setFill(color);
    }
}
