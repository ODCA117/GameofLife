import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * Representing the Tile;
 * contains color of the tile and size;
 */
public class Tile extends Rectangle{


    Tile (){
        super(25,25);
        setFill(Color.GREY);
    }

    public void changeColor(Color color){
        setFill(color);
    }

    public double side(){
        return getHeight();
    }

//some comments
}
