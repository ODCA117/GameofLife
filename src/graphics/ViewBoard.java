package graphics;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ViewBoard {
    private GridPane gridPane;

    public ViewBoard(){
        gridPane = new GridPane();
    }

    public void addNode(Node node, int y, int x){
        gridPane.add(node,y,x);
    }


}
