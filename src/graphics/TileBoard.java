package graphics;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.List;

public class TileBoard {
    private GridPane gridPane;

    public TileBoard(int side){
        gridPane = new GridPane();
        Tile[][] tiles = createTileBoard(side);
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                gridPane.add(tiles[i][j], j, i);
            }
        }

    }

    public void addNode(Node node, int y, int x){
        gridPane.add(node,y,x);
    }

    private Tile[][] createTileBoard(int side){

        Tile[][] tiles = new Tile[side][side];

        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                tiles[i][j] = new Tile();
            }
        }

        return tiles;
    }




}
