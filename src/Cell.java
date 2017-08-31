import javafx.scene.paint.Color;

/**
 * Created by ol6803ax-s on 31/08/17.
 */
public class Cell {

    boolean willLive;
    Color color;
    Tile tile;




    Cell(){
        willLive = false;
        color = Color.GREY;
        tile = new Tile();

    }

}
