package graphics;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class TileBoard {
    private GridPane gridPane;

    public TileBoard(){
        gridPane = new GridPane();
    }

    public void addNode(Node node, int y, int x){
        gridPane.add(node,y,x);
    }




}
